package biz.evolix.model.dao;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Order;

@Repository
@Transactional
public class OrderDAOImp extends JpaDaoSupport implements OrderDAO {

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void newOrder(Order o) {
		getJpaTemplate().persist(o);		
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Order o) {
		getJpaTemplate().merge(o);		
	}

}
