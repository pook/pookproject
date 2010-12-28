package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Sku;
import biz.evolix.model.Users;

public interface PurcheseService {	
	public Users userMember(String user);
	public int size();
	public boolean newOrder(Users u);
	public List<Order> odering();
	public List<Purchese>purchese();
	public Sku loadSku(long sku);
	public boolean buyItem(Sku sku,Integer q);
	public boolean save();
	public void del(int sku);
	public void edit(int idx,Sku sku,Integer quantity);	
}
