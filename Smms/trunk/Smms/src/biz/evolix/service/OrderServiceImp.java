package biz.evolix.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Users;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.Role;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.GrantedAuthorityImp;
import biz.evolix.secure.SmileUser;

public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private UpdateComService updateComService;
	private List<Order> orders;
	private List<Purchese> purcheses;

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
	public List<Purchese> purcheses(int idx) {
		Order o = getOrders().get(idx - 1);
		return o.getPurchese();
	}

	@Override
	public List<Order> ordersByOwner(int from, int rows) {
		Users user = usersDAO.find(getUsers().getUserid());
		setOrders(orderDAO.showOrderOwner(user, false, from, rows));
		return getOrders();
	}

	
	@Override
	public long sizeAll(boolean cancel) {
		long size = 0;		
		size = (getUsers().getAuthorities().contains(new GrantedAuthorityImp(
				Role.ROLE_ADMIN.name()))) ? orderDAO.sizeAll(cancel) : orderDAO
				.sizeByStaff(getUsers().getBrance(), cancel);					
		return size;		
	}

	@Override
	public int sizeOrderOwner() {
		Users user = usersDAO.find(getUsers().getUserid());
		return (int) orderDAO.sizeOrderOwner(user, false);
	}

	@Override
	public List<Order> ordersAll(boolean cancel, int from, int rows) {
		List<Order> orders = (getUsers().getAuthorities().contains(new GrantedAuthorityImp(
				Role.ROLE_ADMIN.name())))?orderDAO.showOrderAll(cancel, from, rows):orderDAO.showOrderStaff(getUsers().getBrance(), cancel, from, rows);
		setOrders(orders);
		return getOrders();
	}

	@Override
	public void del(int id) {
		Order order = getOrders().get(id);
		long l = order.getOrderId();
		if (order.getTotalQuantity() == ConstType.ZERO) {
			try {
				orderDAO.del(l);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} else if (order.getReaded() == false) {
			order.setCanceled(true);
			updateComService.dec(order);
			orderDAO.update(order);
		}
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUpdateComService(UpdateComService updateComService) {
		this.updateComService = updateComService;
	}

	public UpdateComService getUpdateComService() {
		return updateComService;
	}
}
