package biz.evolix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.OrderJdbcDAO;

public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderJdbcDAO orderJdbcDAO;
	
	private List<Order>orders;
	private List<Purchese>purcheses;
	@Override
	public int size() {		
		return getOrderJdbcDAO().size();
	}
	public void setOrderJdbcDAO(OrderJdbcDAO orderJdbcDAO) {
		this.orderJdbcDAO = orderJdbcDAO;
	}
	public OrderJdbcDAO getOrderJdbcDAO() {
		return orderJdbcDAO;
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
	
}
