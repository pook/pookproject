package biz.evolix.model.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Order;
import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.GenericSize;
import biz.evolix.model.dao.callback.GenericSizeByCause;
import biz.evolix.model.dao.callback.MaxResaultByOwner;
import biz.evolix.model.dao.callback.MaxResult;
import biz.evolix.secure.SmileUser;

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
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Order> showOrder(Users u, int f, int m) {	//owner	
		try{
			return (List<Order>)getJpaTemplate().execute(new MaxResaultByOwner<Order>("findOrderOwner", u,f, m));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;		
	}
	@Transactional(readOnly=true)
	public List<Order> showOrderByStaff(Users u, int f, int m) {		
		try{
			return (List<Order>)getJpaTemplate().execute(new MaxResaultByOwner<Order>("findOrderByStaff", u,f, m));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;		
	}
	 
	
	
	private static Logger log = Logger.getLogger(OrderDAOImp.class);



	
	@Override
	public int pSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long sizeAll() {		
		try{
			return getJpaTemplate().execute(new GenericSize<Long>("getSizeOrderAll"));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new PersistenceException();
		}		
	}

	@Override
	public long sizeOrderStaff() {		
		try{
			return getJpaTemplate().execute(new GenericSizeByCause<Long,Users>("getSizeOrderByStaff",getUsers().getNode().getUser()));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new PersistenceException();
		}			
	}

	@Override
	public long sizeOrderOwner() {		
		try{
			return getJpaTemplate().execute(new GenericSizeByCause<Long,Users>("getSizeOrderOwner",getUsers().getNode().getUser()));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new PersistenceException();
		}		
	}	
	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}

}
