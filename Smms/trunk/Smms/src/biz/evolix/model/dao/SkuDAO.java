package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Sku;

public interface SkuDAO {
	public void addItem(Sku p);
	public List<Sku> showAllItem();
	public void remove(Sku sku); 
	public Sku find(long id);
	public List<Sku>find(int from,int to);
}
