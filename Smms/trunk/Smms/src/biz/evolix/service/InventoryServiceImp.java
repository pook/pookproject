package biz.evolix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Sku;
import biz.evolix.model.dao.SkuDAO;

public class InventoryServiceImp implements InventoryService{
	
	@Autowired
	private SkuDAO skuDAO;
	
	@Override
	public void addItem(List<Sku> skus) {		
		for(Sku s:skus){
			skuDAO.addItem(s);
		}		
	}
	public void setSkuDAO(SkuDAO skuDAO) {
		this.skuDAO = skuDAO;
	}
	public SkuDAO getSkuDAO() {
		return skuDAO;
	}
	@Override
	public List<Sku> showItem() {
		return skuDAO.showAllItem();
	}
		
}
