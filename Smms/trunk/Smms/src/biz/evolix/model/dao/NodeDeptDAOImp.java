package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;

@Repository
@Transactional
public class NodeDeptDAOImp extends JpaDaoSupport implements NodeDeptDAO {

	private Node1DAO node1DAO;
	private PageDAO pageDAO;

	@Override
	@Transactional(readOnly = true)
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

	@SuppressWarnings("unused")
	@Transactional
	private void updateNodeDept2(NodeDescription dHead) {
		dHead.setHigh(dHead.getHigh() + 1);
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

	@Override
	public void flush() {
		try {
			getJpaTemplate().flush();
		} catch (Exception e) {
		}
	}
}
