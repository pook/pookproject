package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Sku;

public interface SkuDAO {
	public void addItem(Sku p);	
	public void remove(long sku); 
	public boolean update(Sku sku);
	public Sku find(long id);		
	public List<Sku>findLimit(int min,int maxResult);
	public long size();
	public List<Sku> showAllItem();
}
