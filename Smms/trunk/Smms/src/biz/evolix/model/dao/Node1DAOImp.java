package biz.evolix.model.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;

@Repository
@Transactional
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {

	@Override
	@Transactional(readOnly = true,propagation=Propagation.REQUIRES_NEW)
	public Node1 getNode1(Long node) {
		Node1 n = null;
		try{
			n=getJpaTemplate().find(Node1.class, node);
		}catch (Exception e) {
			System.err.println(e);
		}		
		return n;
	}

	@Override
	@Transactional(readOnly = true)
	public Node1 getNode1FromUserId(String u) throws NullPointerException,DataAccessException{
		if(getJpaTemplate().getEntityManagerFactory()==null)System.out.println("zzzzzzzzzzz");
		return (Node1) getJpaTemplate().findByNamedQuery(
				"select N from Node1 N where N.user=?1", u).get(0);

	}
}
