package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Users;

public interface OrderDAO {
	public void newOrder(Order o);
	public void update(Order o);
	public List<Order>showOrder(Users u,int f,int t);
	public List<Order> showOrderByStaff(Users u, int f, int t);
	public int size();
	public int pSize();
}
