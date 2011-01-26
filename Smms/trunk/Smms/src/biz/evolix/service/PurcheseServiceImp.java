package biz.evolix.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Sku;
import biz.evolix.model.Users;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.SkuDAO;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class PurcheseServiceImp implements PurcheseService {

	private static Logger log = Logger.getLogger(PurcheseServiceImp.class);

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private UpdateComService updateComService;
	@Autowired
	private SkuDAO skuDAO;

	private List<Order> ordering = new ArrayList<Order>();

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

	@Override
	public int size() {
		return getOrdering().size();
	}

	@Override
	public Users userMember(String smileId) {
		return usersDAO.findBySmileUser(smileId);
	}

	@Override
	public boolean newOrder(Users u) {
		Order o = new Order();
		o.setUser(u);
		o.setBrance(getUsers().getBrance());
		o.setSeller(getUsers().getUserid());
		o.setPurchese(new ArrayList<Purchese>());
		o.setDate(new Date());
		if (getOrdering().isEmpty()) {
			o = orderDAO.newOrder(o);
			if (o == null)
				return false;
			getOrdering().add(o);
		}
		return true;
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

	@Override
	public List<Order> odering() {
		return getOrdering();
	}

	@Override
	public List<Purchese> purchese() {
		return getOrdering().get(ConstType.ZERO).getPurchese();
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
			purchese().add(purchese().size(), p);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public boolean save() {
		if (size() == 1
				&& !getOrdering().get(ConstType.ZERO).getPurchese().isEmpty()) {
			try {
				orderDAO.update(getOrdering().get(0));
				updateComService.update(getOrdering().get(0));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}

			setOrdering(new ArrayList<Order>());
			return true;
		}
		return false;
	}

	public void setUpdateComService(UpdateComService updateComService) {
		this.updateComService = updateComService;
	}

	public UpdateComService getUpdateComService() {
		return updateComService;
	}

	@Override
	public void del(int sku) { // remove sku
		getOrdering().get(ConstType.ZERO).getPurchese().remove(sku);
		getOrdering().get(0).getTotalQuantity();
		getOrdering().get(0).getTotalPrice();
		getOrdering().get(0).getTotalSv();			
		orderDAO.update(getOrdering().get(0));
	}

	@Override
	public void edit(int idx, Sku sku, Integer quantity) {
		try {
			getOrdering().get(ConstType.ZERO).getPurchese().get(idx - 1)
					.setQuantity(quantity);
			getOrdering().get(0).getTotalQuantity();
			getOrdering().get(0).getTotalPrice();
			getOrdering().get(0).getTotalSv();
			orderDAO.update(getOrdering().get(0));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}