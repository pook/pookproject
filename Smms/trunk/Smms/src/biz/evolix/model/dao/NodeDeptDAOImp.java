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

@Repository
@Transactional
public class NodeDeptDAOImp extends JpaDaoSupport implements NodeDeptDAO {

	private Node1DAO node1DAO;

	@Override
	@Transactional(readOnly = true)
	public NodeDescription id(NodePK id) {
		NodeDescription d = null;
		try {
			d = getJpaTemplate().find(NodeDescription.class, id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return d;
	}

	private static Logger log = Logger.getLogger(NodeDescription.class);

	@Override
	@Transactional
	public void updateNodeDept(long nxt, NodeDescription dept) {
		while (nxt > dept.getUpper()) {
			dept.setLevel(dept.getLevel() + 1);
			dept.setLower(Generate.left(dept.getLower()));
			dept.setUpper(Generate.right(dept.getUpper()));
			dept.setNextId(dept.getLower());
			try {
				getJpaTemplate().merge(dept);
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
	public NodePK nextId(Long useId, String treeId, Long pos1) {
		NodeDescription d = null;		
		NodePK id = new NodePK(treeId, pos1);
		d = description(id);
		boolean auto = (useId == ConstType.AUTO) ? true : false;
		if (!auto) {
			NodePK id2 = new NodePK(treeId, useId);			
			if (getNodeFromId(id2) == null)	return id2;			
			auto = true;
		}
		NodePK id2 = new NodePK(d.getTreeId(), d.getNextId());
		if (auto) {
			Node1 next = null;			
			while ((next = getNodeFromId(id2)) != null) {				
				if (next.getPos() > d.getUpper()) {					
					updateNodeDept(d.getNextId(), d);
					id = new NodePK(d.getTreeId(), d.getNextId());					
				} else {
					id2.next();					
				}
			}
			if (next == null) {
				if (id2.testNext() > d.getUpper()) {
					long upper = d.getUpper();
					updateNodeDept(id2.testNext(), d);
					if(id2.getPos()>upper)
						id2.setPos(d.getNextId());										
				} else {
					d.setNextId(id2.testNext());
					update(d);
				}
			}
		}
		return id2;
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
	private NodeDescription description(NodePK id) {
		return getJpaTemplate().find(NodeDescription.class, id);
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
}
