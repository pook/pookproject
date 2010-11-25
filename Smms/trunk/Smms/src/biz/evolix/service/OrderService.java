package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;

public interface OrderService {
	public int size();
	public int pSize();
	public List<Order>orders(int from,int to,int rows);
	public List<Purchese>purcheses(int idx);
	public List<Order>ordersByMember(int from,int to,int rows);
}
