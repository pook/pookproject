package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.Page;

@Repository
@Transactional
public class NodeDeptDAOImp extends JpaDaoSupport implements NodeDeptDAO {

	private Node1DAO node1DAO;
	private PageDAO pageDAO;

	@Override
	@Transactional
	public NodeDescription find(NodePK id) {
		NodeDescription d = null;
		try {
			d = getJpaTemplate().find(NodeDescription.class, id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return d;
	}

	private static Logger log = Logger.getLogger(NodeDeptDAOImp.class);

	@Override
	@Transactional(readOnly = false)
	public void updateNodeDept(long nxt, NodeDescription dept, boolean test) {
		if (test) {
			// if()
			while (nxt > dept.getUpper()) {
				dept.setLevel(dept.getLevel() + 1);
				dept.setLower(Generate.left(dept.getLower()));
				dept.setUpper(Generate.right(dept.getUpper()));
				dept.setNextId(dept.getLower());
				dept.setCount(0L);
			}
			try {
				getJpaTemplate().merge(dept);
				getJpaTemplate().flush();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	@Override
	@Transactional
	public boolean insert(NodeDescription nodeDept) {
		try {
			getJpaTemplate().persist(nodeDept);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Transactional
	public NodeDescription nextId(NodeDescription dHead, long useId, NodePK id,
			boolean auto) {
		dHead = find(id);
		NodeDescription newDept = null;
		if (!auto) {
			NodePK id2 = new NodePK(id.getTreeId(), useId);
			if (getNodeFromId(id2) == null) {
				newDept = new NodeDescription(id2);
			}
			auto = true;
		}
		int level = dHead.getLevel();
		long maxnode = Generate.math2Pow(level), count = dHead.getCount();
		NodePK id2 = new NodePK(dHead.getTreeId(), dHead.getNextId());
		boolean found = false;
		if (auto) {
			Node1 node = null;
			while (!found) {				
				while (count < maxnode - 1 && !found) {
					if ((node = getNodeFromId(id2)) == null) {
						found = true;
					} else if (id2.getPos() == dHead.getUpper()) {
						String next = pageDAO.lookup(id2.getTreeId());
						id2 = new NodePK(next, maxnode);
					} else {						
						id2 = new NodePK(id2.getTreeId(), id2.testNext());
					}
					dHead.setCount(++count);
					dHead.setNextId(dHead.getNextId() + 1);
				}
				if (count + 1 == maxnode && !found) {
					id2 = new NodePK(id2.getTreeId(), dHead.getUpper());
					if ((node = getNodeFromId(id2)) == null) 
						found = true;					
					if (dHead.getUpper() < ConstType.MAX_NODE63
							&& dHead.getUpper() >= ConstType.MAX_NODE62) {
						NodePK beforeLower = null;
						if (found){							
							pageDAO.insert(new Page(new NodePK(id2.getTreeId(),
									id2.getPos()).hashNode1(), new NodePK(id2
									.getTreeId(), id2.testNext()).hashNode1()));
							//id2.setTree();
						}else;
							beforeLower = new NodePK(dHead.getTreeId(),
								dHead.getLower());
						updateNodeDept2(dHead);
						if (!found)
							id2 = new NodePK(beforeLower.hashNode1(), 2);
					} else {
						updateNodeDept(dHead.getUpper() + 1, dHead, true);
						
						if (!found)
							id2 = new NodePK(dHead.getTreeId(),
									dHead.getNextId());						
					}
					if (!found) {
						level = dHead.getLevel();
						count = dHead.getCount();
						maxnode = Generate.math2Pow(level);
					}
				}				
			}
		}
		newDept = new NodeDescription(id2);
		insert(newDept);
		return newDept;
	}

	@Transactional
	private void updateNodeDept2(NodeDescription dHead) {
		dHead.setLevel(dHead.getLevel() + 1);
		dHead.setLower(2L);
		dHead.setUpper(3L);
		dHead.setCount(0L);
		dHead.setNextId(dHead.getLower());
	}

	@Override
	@Transactional
	public void update(NodeDescription dept) {
		try {
			getJpaTemplate().merge(dept);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Transactional(readOnly = true)
	private Node1 getNodeFromId(NodePK id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, id);
		} catch (Exception e) {
		}
		return n;
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	public PageDAO getPageDAO() {
		return pageDAO;
	}
}
