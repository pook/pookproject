package biz.evolix.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Order;
import biz.evolix.model.Users;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Order> showOrder(Users u, int f, int t) {		
		try{
			return (List<Order>)getJpaTemplate().find("select O from Order O where  O.orderId>?1 and O.orderId <?2 and O.user =?3",f,t,u);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;		
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Order> showOrderByStaff(Users u, int f, int t) {		
		try{
			return (List<Order>)getJpaTemplate().find("select O from Order O where  O.orderId>?1 and O.orderId <?2 and O.seller =?3",f,t,u);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;		
	}
	 
	
	
	private static Logger log = Logger.getLogger(OrderDAOImp.class);



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pSize() {
		// TODO Auto-generated method stub
		return 0;
	}	
}
