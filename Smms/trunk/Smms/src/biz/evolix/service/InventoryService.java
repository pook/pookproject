package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Sku;

public interface InventoryService {
	public void addSku(Sku sku);//insert		
	public boolean remove(int id); //delete
	public boolean update(Sku sku);
	public Sku find(int id);
	public List<Sku> find(int min,int maxResult);
	public int count();
	/*
	 * insert
	 * update
	 * delete
	 */
}
