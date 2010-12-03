package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Sku;

public interface InventoryService {
	public void addSku(Sku sku);//insert		
	public boolean remove(int id); //delete
	public Sku find(long id);
	public List<Sku> find(int min,int maxResult);
	public int count();
	/*
	 * insert
	 * update
	 * delete
	 */
}