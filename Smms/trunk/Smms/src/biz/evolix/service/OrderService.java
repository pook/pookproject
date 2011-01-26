package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;

public interface OrderService {
	public long sizeAll(boolean cancel);	
	public int sizeOrderOwner();	
	public List<Order>ordersAll(boolean cancel,int from,int rows);	
	public List<Order>ordersByOwner(int from,int rows);
	public void del(int id);	
	public List<Purchese>purcheses(int idx);
}
