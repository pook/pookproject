package biz.evolix.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import biz.evolix.model.Sku;
import biz.evolix.model.dao.SkuDAO;
import biz.evolix.model.dao.SkuJdbcDAO;

public class InventoryServiceImp  implements InventoryService{
	
	@Autowired
	private SkuDAO skuDAO;
	@Autowired
	private SkuJdbcDAO skuJdbcDAO; 
	
	private List<Sku> skus;
	
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
		skuDAO.addItem(sku);		
	}
	@Override
	public boolean remove(int id) {
		try{
			long sku =getSkus().get(id-1).getSid();
			getSkuDAO().remove(sku);			
			return true;
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}		
		return false;
	}
	@Override
	public Sku find(long id) {		
		return skuDAO.find(id);
	}
	@Override
	public List<Sku> find(int from, int to,int rows) {
		/*
		to+=2;
		System.out.println("Rows :"+rows+"\n"+to+"\n"+from);
		int size = to-from;
		while(size++<rows)++to;
		setSkus(skuDAO.find(from, to));
		return getSkus();
		*/
		List<Sku> s =skuDAO.findLimit(3, 5);
		System.out.println(">>>>>>>"+s.size());
		return s;
	}		
	 
	public List<Sku> getSkus() {
		return skus;
	}
	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	public int count(){		
		return skuJdbcDAO.size();
	}
	public void setSkuJdbcDAO(SkuJdbcDAO skuJdbcDAO) {
		this.skuJdbcDAO = skuJdbcDAO;
	}
	public SkuJdbcDAO getSkuJdbcDAO() {
		return skuJdbcDAO;
	}
	private static Logger log = Logger.getLogger(InventoryServiceImp.class);
	
}
