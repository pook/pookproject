package com.smms.action;

import java.util.ArrayList;
import java.util.List;

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

	private List<String> products;
	private SkuDAO skuDAO;
	@Action(value = "/customer-loadskuss", results = { @Result(location = "select-sku.jsp", name = "success")})
	public String execute() throws Exception {	
		List<Sku> skus=skuDAO.showAllItem();
		System.out.println();
		int i=0;
		for(Sku k:skus){
			System.out.println("ccc"+k.getName());
			products.add((i++)+k.getName());
		}
		System.out.println(products);
		return SUCCESS;
	}
	public LoadSkus2(SkuDAO skuDAO) {
		super();
		this.skuDAO = skuDAO;
		products = new ArrayList<String>();
	}
	/*
	public String getJSON() throws Exception {
		
		return SUCCESS;
	}*/
	public void setProducts(List<String> products) {
		this.products = products;
	}
	public List<String> getProducts() {
		return products;
	}

}
