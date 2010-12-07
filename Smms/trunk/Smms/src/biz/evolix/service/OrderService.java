package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;

public interface OrderService {
	public long sizeAll();	
	public int sizeOrderOwner();	
	public List<Order>ordersAll(int from,int rows);
	public List<Purchese>purcheses(int idx);
	public List<Order>ordersByOwner(int from,int rows);
}
