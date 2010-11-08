package com.smms.action;

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
public class LoadSkusAct extends ActionSupport {

	private static final long serialVersionUID = -9096770255426595255L;

	private List<Sku> products;
	private SkuDAO skuDAO;
	@Action(value = "/jsonloadskus", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		if(products==null)
			products=skuDAO.showAllItem();
		return SUCCESS;
	}
	public LoadSkusAct(SkuDAO skuDAO) {
		super();
		this.skuDAO = skuDAO;
	}
	public String getJSON() throws Exception {
		return execute();
	}
	public void setProducts(List<Sku> products) {
		this.products = products;
	}
	public List<Sku> getProducts() {
		return products;
	}

}
