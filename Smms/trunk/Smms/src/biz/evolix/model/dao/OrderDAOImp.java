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
import biz.evolix.model.dao.callback.MaxResult;
import biz.evolix.model.dao.callback.MaxResultCon1;
import biz.evolix.secure.SmileUser;

@Repository
@Transactional
public class OrderDAOImp extends JpaDaoSupport implements OrderDAO {

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Order newOrder(Order o) {
		try {
			getJpaTemplate().persist(o);
			return o;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return o;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Order o) {
		try {
			getJpaTemplate().merge(o);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private static Logger log = Logger.getLogger(OrderDAOImp.class);

	@Override
	@Transactional(readOnly = true)
	public long sizeAll() {
		try {
			return getJpaTemplate().execute(
					new GenericSize<Long>("getSizeOrderAll"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new PersistenceException();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public long sizeOrderOwner(Users user) {
		try {		
			return getJpaTemplate()
					.execute(
							new GenericSizeByCause<Long, Users>(
									"getSizeOrderOwner", user));// object
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new PersistenceException();
		}
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Order> showOrderAll(int f, int m) {
		return (List<Order>) getJpaTemplate().execute(
				new MaxResult<Order>(f, m, "findOrderAll"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> showOrderOwner(Users user, int f, int m) {
		try{			
			return (List<Order>) getJpaTemplate().execute(
					new MaxResultCon1<Order>( user, f, m,"findOrderbyOwner"));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean del(long id) {
		try {
			Order o = getJpaTemplate().find(Order.class, id);
			getJpaTemplate().remove(o);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}
}
