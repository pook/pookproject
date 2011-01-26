package biz.evolix.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Order;
import biz.evolix.model.Users;

import biz.evolix.model.dao.callback.FindByCondition1;
import biz.evolix.model.dao.callback.FindByCondition2;
import biz.evolix.model.dao.callback.FindListByCondition2;
import biz.evolix.model.dao.callback.MaxResultCon1;
import biz.evolix.model.dao.callback.MaxResultCon2;

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
			log.error(e.getMessage());
			return o;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Order o) {
		try {
			getJpaTemplate().merge(o);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	private static Logger log = Logger.getLogger(OrderDAOImp.class);

	@Override
	@Transactional(readOnly = true)
	public long sizeAll(boolean cancel) {
		long s = 0;
		try {
			s = getJpaTemplate().execute(
					new FindByCondition1<Long>(cancel, "getSizeOrderAll"));
		} catch (Exception e) {
			log.error(e.getMessage(),e);			
		}
		return s;
	}

	@Override
	@Transactional(readOnly = true)
	public long sizeOrderOwner(Users user, boolean cancel) {
		long s = 0;
		try {
			s = getJpaTemplate().execute(
					new FindByCondition2<Long>(user,cancel, "getSizeOrderOwner"));// object
		} catch (Exception e) {
			log.warn(e.getMessage(),e);			
		}
		return s;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> showOrderAll(boolean cancel, int f, int m) {
		try {
			return (List<Order>) getJpaTemplate().execute(
					new MaxResultCon1<Order>(cancel, f, m, "findOrderAll"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new ArrayList<Order>();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> showOrderOwner(Users user, boolean cancel, int f, int m) {
		try {
			return (List<Order>) getJpaTemplate().execute(
					new MaxResultCon2<Order>(user, cancel, f, m,
							"findOrderbyOwner"));
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
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
			log.error(e.getMessage());
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Order> showOrderStaff(String brance, boolean cancel, int f, int m) {
		List<Order>orders = null;
		try{
			orders =(List<Order>) getJpaTemplate().executeFind(new FindListByCondition2<Order>("findOrderByStaff",brance , cancel));
		}catch(Exception e){
			log.warn(e.getMessage(),e);
		}
		return orders;
	}

	@Override
	@Transactional(readOnly = true)
	public long sizeByStaff(String brance, boolean cancel) {
		long s = 0;
		try {
			s = getJpaTemplate().execute(
					new FindByCondition2<Long>(brance, cancel,
							"getSizeOrderByStaff"));
		} catch (Exception e) {
			log.warn(e.getMessage(),e);			
		}
		return s;
	}
}
