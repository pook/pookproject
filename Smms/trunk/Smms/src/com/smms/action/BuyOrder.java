package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class BuyOrder extends ActionSupport {

		private static final long serialVersionUID = -2300418320210586222L;
		@Action(value = "/order-purchese-staff", results = {
				@Result(location = "blackoffice.jsp", name = "success"),
				@Result(location = "echo/error-redirect.jsp", name = "error") ,
				@Result(location = "blackoffice.jsp", name = "input") })
		public String execute() {
			if(purcheseService.save())
			return SUCCESS;
			addActionError("ควรชื้อสินค้าอย่างน้อย 1 รายการ");
			return ERROR;
		}		
			
		private PurcheseService purcheseService;
		public BuyOrder(PurcheseService purcheseService) {
			super();
			this.purcheseService = purcheseService;
		}

}
