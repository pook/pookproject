package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Sku;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.SkuDAO;

public class PurcheseServiceImp implements PurcheseService {
	
	private static Logger log = Logger.getLogger(PurcheseServiceImp.class);

//	@Autowired
//	private PurcheseDAO purcheseDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private UpdateComService updateComService;
	@Autowired
	private SkuDAO skuDAO;

	private List<Order> ordering = new ArrayList<Order>();;

//	public void setPurcheseDAO(PurcheseDAO purcheseDAO) {
//		this.purcheseDAO = purcheseDAO;
//	}
//
//	public PurcheseDAO getPurcheseDAO() {
//		return purcheseDAO;
//	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrdering(List<Order> ordering) {
		this.ordering = ordering;
	}

	public List<Order> getOrdering() {
		return ordering;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	@Override
	public int size() {
		return getOrdering().size();
	}

	@Override
	public Users userMember(String user) {
		return authoritiesDAO.findUser(user);
	}

	@Override
	public boolean newOrder(Users u) {
		Order o = new Order();
		o.setUser(u);
		o.setPurchese(new ArrayList<Purchese>());
		orderDAO.newOrder(o);
		getOrdering().add(o);
		return true;
	}

	@Override
	public List<Order> odering() {
		return getOrdering();
	}

	@Override
	public List<Purchese> purchese() {
		return getOrdering().get(0).getPurchese();
	}

	@Override
	public Sku loadSku(long sku) {
		return skuDAO.find(sku);
	}

	@Override
	public boolean buyItem(Sku sku, Integer q) {
		try {
			Purchese p = new Purchese();
			p.setQuantity(q);
			p.setSku(sku);
			p.setOrder(getOrdering().get(0));
			purchese().add(purchese().size(),p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean save() {
		System.out.println("Update ");
		long s = System.currentTimeMillis();
		log.info("Time Start>>>>>>>>>"+s);
		System.out.println("Time Start>>>>>>>>>"+s );
		if (size() == 1) {
			orderDAO.update(getOrdering().get(0));
			updateComService.update(getOrdering().get(0));
			setOrdering(new ArrayList<Order>());
		}
		long t= System.currentTimeMillis() - s;
		System.out.println("Time Stop>>>>>>>>>" + t);
		log.info("Time Stop>>>>>>>>>" + t);
		return false;
	}

	public void setUpdateComService(UpdateComService updateComService) {
		this.updateComService = updateComService;
	}

	public UpdateComService getUpdateComService() {
		return updateComService;
	}

	@Override
	public void del(int sku) {	
		//System.out.println("sk "+sku);
		//Sku sku1 = loadSku(sku);
		getOrdering().get(0).getPurchese().remove(sku);
	}
	
	@Override
	public void edit(int idx, Sku sku, Integer quantity) {
		getOrdering().get(0).getPurchese().remove(idx);
		buyItem(sku, quantity);		
	}
	

}
