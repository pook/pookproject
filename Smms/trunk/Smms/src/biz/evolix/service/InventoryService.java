package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Sku;

public interface InventoryService {
	public void addSku(Sku sku);//insert
	public List<Sku> findAllSku();	
	public boolean remove(int id); //delete
	public Sku find(long id);
	public List<Sku> find(int from,int to,int rows);
	public int count();
	/*
	 * insert
	 * update
	 * delete
	 */
}
