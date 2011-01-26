package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Users;

public interface OrderDAO {
	public Order newOrder(Order o);
	public void update(Order o);
	public List<Order>showOrderOwner(Users user,boolean cancel,int f,int m);
	public List<Order>showOrderAll(boolean cancel,int f,int m);
	public List<Order>showOrderStaff(String brance,boolean cancel,int f,int m);
	public long sizeAll(boolean cancel);
	public long sizeByStaff(String brance,boolean cancel);
	public long sizeOrderOwner(Users user,boolean cancel);
	public boolean del(long id);
}
