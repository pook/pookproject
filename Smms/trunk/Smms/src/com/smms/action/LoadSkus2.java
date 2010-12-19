package com.smms.action;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Sku;
import biz.evolix.model.dao.SkuDAO;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class LoadSkus2 extends ActionSupport {

	private static final long serialVersionUID = -9096770255426595255L;

	private Map<Integer,String> products = new TreeMap<Integer,String>();
	private SkuDAO skuDAO;
	@Action(value = "/json-customer-loadskuss", results = { @Result(location = "select-sku.jsp", name = "success")})
	public String execute() throws Exception {	
		List<Sku> skus=skuDAO.showAllItem();		
		for(Sku k:skus){
			products.put(Integer.parseInt(k.getSid().toString()), k.getName());
		}
		return SUCCESS;
	}
	public LoadSkus2(SkuDAO skuDAO) {
		super();
		this.skuDAO = skuDAO;		
	}

	public String getJSON() throws Exception {		
		return execute();
	}
	public Map<Integer, String> getProducts() {
		return products;
	}
	public void setProducts(Map<Integer, String> products) {
		this.products = products;
	}
	
}
