package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditPurcheseAct extends ActionSupport {

	private static final long serialVersionUID = -176656484298914894L;

	private PurcheseService purcheseService;
	private String orderId;
	private String pId;
	
	@Action(value = "/edit-grid-purchese", results = {
			@Result(location = "blackoffice.jsp", name = "success"),
			@Result(location = "blackoffice.jsp", name = "input") }
	)
	public String execute() throws Exception {
		System.out.println(">> ");		
		return SUCCESS;
	}

	public EditPurcheseAct(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	
	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpId() {
		return pId;
	}

}
