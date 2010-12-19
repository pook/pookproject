package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Order;

public interface OrderDAO {
	public void newOrder(Order o);
	public void update(Order o);
	public List<Order>showOrderOwner(String uid,int f,int m);
	public List<Order>showOrderAll(int f,int m);	
	public long sizeAll();
	public long sizeOrderOwner();
	public boolean del(long id);
}
