package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.Purchese;
import biz.evolix.model.Sku;
import biz.evolix.model.dao.OrderDAO;
import biz.evolix.model.dao.PurcheseDAO;
import biz.evolix.model.dao.SkuDAO;

public class PurcheseServiceImp extends JpaDaoSupport implements
		PurcheseService {

	@Autowired
	private SkuDAO skuDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private PurcheseDAO purcheseDAO;
	
//	private 
	
	private List<Purchese>purcheses=new ArrayList<Purchese>();
	
	@Override	
	public boolean buy(Sku sku) {
		Purchese p = new Purchese();
		p.setSku(sku);
		//p.setOrder(order);
		getPurcheses().add(p);
		return false;
	}

	public void setSkuDAO(SkuDAO skuDAO) {
		this.skuDAO = skuDAO;
	}

	public SkuDAO getSkuDAO() {
		return skuDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setPurcheseDAO(PurcheseDAO purcheseDAO) {
		this.purcheseDAO = purcheseDAO;
	}

	public PurcheseDAO getPurcheseDAO() {
		return purcheseDAO;
	}

	public void setPurcheses(List<Purchese> purcheses) {
		this.purcheses = purcheses;
	}

	public List<Purchese> getPurcheses() {
		return purcheses;
	}
	
}
