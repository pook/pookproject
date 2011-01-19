package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Users;

public interface OrderDAO {
	public Order newOrder(Order o);
	public void update(Order o);
	public List<Order>showOrderOwner(Users user,int f,int m);
	public List<Order>showOrderAll(int f,int m);	
	public long sizeAll();
	public long sizeOrderOwner(Users user);
	public boolean del(long id);
}
