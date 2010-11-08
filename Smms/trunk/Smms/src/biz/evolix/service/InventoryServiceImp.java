package biz.evolix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Sku;
import biz.evolix.model.dao.SkuDAO;

public class InventoryServiceImp implements InventoryService{
	
	@Autowired
	private SkuDAO skuDAO;
	
	public void setSkuDAO(SkuDAO skuDAO) {
		this.skuDAO = skuDAO;
	}
	public SkuDAO getSkuDAO() {
		return skuDAO;
	}
	@Override
	public List<Sku> findAllSku() {
		return skuDAO.showAllItem();
	}
	@Override
	public void addSku(Sku sku) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean remove(Sku sku) {
		try{
			return true;
		}catch (Exception e) {
			
		}
		return false;
	}
	@Override
	public Sku find(long id) {		
		return skuDAO.find(id);
	}
	@Override
	public List<Sku> find(int from, int to) {
		return skuDAO.find(from, to);
	}
		
}
