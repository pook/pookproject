package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;
import biz.evolix.model.dao.callback.FindNode1ByUserId;


@Repository
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {
	private static Logger log = Logger.getLogger(Node1DAOImp.class);

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Node1 getNode1(Long node) {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, node);
			return n;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return n;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	public boolean update(Node1 node) throws DataAccessException {
		try {
			getJpaTemplate().merge(node);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new NullPointerException();
		}
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public boolean updateOther(Node1 node) throws DataAccessException {
		try {
			getJpaTemplate().merge(node);
			getJpaTemplate().flush();
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new NullPointerException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Node1 getNode1FromUserId(String u) throws DataAccessException {
		Node1 n = null;
		try {
			n = (Node1) getJpaTemplate().execute(
					new FindNode1ByUserId<Node1>(u));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return n;
	}
}
