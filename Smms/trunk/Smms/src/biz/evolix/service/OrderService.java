package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;

public interface OrderService {
	public long sizeAll();
	public int sizeOrderStaff();
	public int sizeOrderOwner();
	public List<Order>ordersByStaff(int from,int to,int rows);
	public List<Purchese>purcheses(int idx);
	public List<Order>ordersByMember(int from,int to,int rows);
}
