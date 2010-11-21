package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Sku;

public interface InventoryService {
	public void addSku(Sku sku);
	public List<Sku> findAllSku();	
	public boolean remove(Sku sku);
	public Sku find(long id);
	public List<Sku> find(int from,int to);
	public long count();
}
