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
		@Action(value = "/order-purchese", results = {
				@Result(location = "blackoffice2.jsp", name = "success"),
				@Result(location = "blackoffice2.jsp", name = "input") })
		public String execute() {
			purcheseService.save();
			return SUCCESS;
		}
		
			
		private PurcheseService purcheseService;
		public BuyOrder(PurcheseService purcheseService) {
			super();
			this.purcheseService = purcheseService;
		}

}
