package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;

@Repository
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {
	private static Logger log = Logger.getLogger(Node1DAOImp.class);

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Node1 getNode1(Long node){
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
	@Transactional(readOnly = true)
	public Node1 getNode1FromUser(Users u) throws NullPointerException,
			DataAccessException {
		return (Node1) getJpaTemplate().find(
				"select N from Node1 N where N.user=?1", u).get(0);

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
	public Node1 getNode1FromUserId(String u) throws DataAccessException {
		Node1 n = null;		
		try {
			n = (Node1)getJpaTemplate().find("select N from Node1 N where N.user.userId=?1",u).get(0);
		} catch (Exception e) {
			log.error(e.getMessage(), e);		
		}
		return n;
	}
}
