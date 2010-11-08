package com.smms.action;


import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Order;
import biz.evolix.model.Purchese;
import biz.evolix.model.Users;
import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditOrderAct extends ActionSupport {

	private static final long serialVersionUID = -6282900355788185531L;
	private static final Log log = LogFactory.getLog(Login.class);

	private String oper;
	private Users user;
	private Integer orderId;
	private PurcheseService purcheseService;

	@Action(value = "/edit-grid-order", results = {
			@Result(location = "blackoffice.jsp", name = "success"),
			@Result(location = "blackoffice.jsp", name = "input") })
	public String execute() {
		System.out.println("2+" + getOper());
		System.out.println("3333+" + getUser().getUserId());
		System.out.println("bbb");
		try {
			Users u = purcheseService.userMember(getUser().getUserId());
			if(u==null){
				addActionError("Member Not Found  !!");
				System.out.println("Member Not found");
			}else{
				log.info("Create order");
				Order o = new Order();
				o.setDate(new Date());
				o.setPurchese(new ArrayList<Purchese>());
				o.setUser(u);
				purcheseService.getCurrentOrder().add(o);
			}			
		} catch (Exception e) {			
			System.out.println("no");
		}
		setOrderId(99);
		return SUCCESS;
	}

	public EditOrderAct(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

	private boolean add() {

		return false;
	}

	private boolean del() {
		return false;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

}
