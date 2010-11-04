package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Sku;

public interface InventoryService {
	public void addItem(List<Sku>skus);
	public List<Sku> showItem();	
}
