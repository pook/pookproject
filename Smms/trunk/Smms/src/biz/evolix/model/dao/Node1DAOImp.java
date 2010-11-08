package biz.evolix.model.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;

@Repository
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Node1 getNode1(Long node) throws DataAccessException {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, node);
			return n;
		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Node1 getNode1FromUserId(String u) throws NullPointerException,
			DataAccessException {
		return (Node1) getJpaTemplate().findByNamedQuery(
				"select N from Node1 N where N.user=?1", u).get(0);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public boolean update(Node1 node) throws DataAccessException {
		try {
			getJpaTemplate().persist(node);
			return true;
		} catch (Exception e) {
			throw new NullPointerException();
		}

	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.DEFAULT)
	public boolean updateOther(Node1 node) throws DataAccessException {
		try {
			getJpaTemplate().merge(node);
			return true;
		} catch (Exception e) {
			throw new NullPointerException();
		}
	}

}
