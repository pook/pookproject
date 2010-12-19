package biz.evolix.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import biz.evolix.model.Sku;
import biz.evolix.model.dao.SkuDAO;

public class InventoryServiceImp  implements InventoryService{
	
	@Autowired
	private SkuDAO skuDAO;
		
	private List<Sku> skus;
	
	public void setSkuDAO(SkuDAO skuDAO) {
		this.skuDAO = skuDAO;
	}
	public SkuDAO getSkuDAO() {
		return skuDAO;
	}
	@Override
	public void addSku(Sku sku) {
		skuDAO.addItem(sku);		
	}
	@Override
	public boolean remove(int id) {
		try{
			long sku =getSkus().get(id).getSid();
			getSkuDAO().remove(sku);			
			return true;
	
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}		
		return false;
	}
	@Override
	public Sku find(int id) {		
		return getSkus().get(id);
	}
	@Override
	public List<Sku> find(int min, int maxResult) {
		setSkus(skuDAO.findLimit(min ,maxResult));
		return getSkus();
	}		
	 
	public List<Sku> getSkus() {
		return skus;
	}
	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	public int count(){		
		return (int) skuDAO.size();
	}
	
	private static Logger log = Logger.getLogger(InventoryServiceImp.class);

	@Override
	public boolean update(Sku sku) {		
		return skuDAO.update(sku);
	}	
}
