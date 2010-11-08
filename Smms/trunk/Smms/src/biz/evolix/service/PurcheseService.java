package biz.evolix.service;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Users;

import java.util.List;

public interface PurcheseService {	
	public List<Order>getNewOrder();
	public boolean addOrder(Users user);
	public List<Order>getCurrentOrder();
	public List<Purchese>getPurcheseFromOrders(int idx);
	public List<Order>getOrder(long idx);
	public Users userMember(String user);
}
