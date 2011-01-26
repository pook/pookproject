package biz.evolix.service;

import biz.evolix.model.Order;

public interface UpdateComService {
	public void update(Order o);
	public void dec(Order o);
}
