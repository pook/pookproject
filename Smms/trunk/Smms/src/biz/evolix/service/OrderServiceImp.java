package biz.evolix.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.secure.SmileUser;

public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	
	private List<Order> orders;
	private List<Purchese> purcheses;

	
	public int size() {
		return getOrderDAO().size();
	}

	public int pSize() {
		return getOrderDAO().pSize();
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrders(List<Order> orders) {	
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setPurcheses(List<Purchese> purcheses) {
		this.purcheses = purcheses;
	}

	public List<Purchese> getPurcheses() {
		return purcheses;
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

	private static Logger log = Logger.getLogger(OrderServiceImp.class);

	@Override
	public List<Order> orders(int from, int to,int rows) {		
		setOrders(getOrderDAO().showOrderByStaff(
				getUsers().getNode().getUser(), from, to));
		return getOrders();
	}

	@Override
	public List<Purchese> purcheses(int idx) {
		Order o=getOrders().get(idx-1);		
		return o.getPurchese();
	}

	@Override
	public List<Order> ordersByMember(int from, int to, int rows) {
		setOrders(getOrderDAO().showOrder(
				getUsers().getNode().getUser(), from, to));
		return getOrders();	}
}
