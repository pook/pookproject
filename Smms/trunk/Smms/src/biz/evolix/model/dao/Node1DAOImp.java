package biz.evolix.model.dao;

import org.apache.log4j.Logger;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.callback.FindFormString;
import biz.evolix.model.dao.callback.FindFromLong;

@Repository
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {
	private static Logger log = Logger.getLogger(Node1DAOImp.class);

	@Override
	public Node1 find(NodePK id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, id);
		} catch (Exception e) {
		}
		return n;
	}

	@Override
	public Node1 findFromUserId(Long id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(
					new FindFromLong<Node1>(id, "findNode1FromUserId"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return n;
	}

	@Override
	@Transactional(readOnly = true)
	public Node1 findFromSmileId(String id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(
					new FindFormString<Node1>(id, "findFromSmileId"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return n;
	}

	@Override
	@Transactional
	public void persist(Node1 node) {
		try {
			getJpaTemplate().persist(node);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}		
	}

	@Override
	public void update(Node1 node) {
		try {
			getJpaTemplate().merge(node);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}			
	}
}
