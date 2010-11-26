package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Sku;

public interface SkuDAO {
	public void addItem(Sku p);
	public List<Sku> showAllItem();
	public void remove(long sku); 
	public Sku find(long id);
	public List<Sku>find(int from,int to);	
	public List<Sku>findLimit(int min,int maxResult);	
}
