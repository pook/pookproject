package biz.evolix.model.dao;

import biz.evolix.model.Order;

public interface OrderDAO {
	public void newOrder(Order o);
	public void update(Order o);
}
