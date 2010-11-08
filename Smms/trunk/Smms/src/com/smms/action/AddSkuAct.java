package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.InventoryService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class AddSkuAct extends ActionSupport {

	private static final long serialVersionUID = 1443126673233497703L;
	private InventoryService inventoryService;

	@Action(value = "/add-sku-grid", results = { @Result(name = "success", type = "json") })
	public String execute() {
		
		return SUCCESS;
	}
	
	private String oper;
	

	public AddSkuAct(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}


	public void setOper(String oper) {
		this.oper = oper;
	}


	public String getOper() {
		return oper;
	}
	
	
	
	
}
