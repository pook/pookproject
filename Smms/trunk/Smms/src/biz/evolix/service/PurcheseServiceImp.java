package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.PurcheseDAO;

public class PurcheseServiceImp implements PurcheseService {

	@Autowired
	private PurcheseDAO purcheseDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	private List<Order> ordering = new ArrayList<Order>();;

	public void setPurcheseDAO(PurcheseDAO purcheseDAO) {
		this.purcheseDAO = purcheseDAO;
	}

	public PurcheseDAO getPurcheseDAO() {
		return purcheseDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	@Override
	public List<Order> getNewOrder() {
		setOrdering(new ArrayList<Order>());
		return getOrdering();
	}

	public void setOrdering(List<Order> ordering) {
		this.ordering = ordering;
	}

	public List<Order> getOrdering() {
		return ordering;
	}

	@Override
	public boolean addOrder(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getCurrentOrder() {
		return getOrdering();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Purchese> getPurcheseFromOrders(int idx) {
		return (List<Purchese>) getOrdering().get(idx);
	}

	@Override
	public List<Order> getOrder(long idx) {
		return getOrdering();
	}

	@Override
	public Users userMember(String user) {	
		try{
			Users u=authoritiesDAO.findUser(user);
			return u;
		}catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO)throws NullPointerException {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

}
