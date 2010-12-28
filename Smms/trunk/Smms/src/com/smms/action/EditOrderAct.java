package com.smms.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Users;
import biz.evolix.service.PurcheseService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditOrderAct extends ActionSupport {

	private static final long serialVersionUID = -6282900355788185531L;
	private static Logger log = Logger.getLogger(EditOrderAct.class);

	private String oper;
	private Users user;
	private Integer orderId;
	private PurcheseService purcheseService;

	@Action(value = "/edit-grid-order", results = {
			@Result(location = "blackoffice.jsp", name = "success"),
			@Result(location = "blackoffice.jsp", name = "input") })
	public String execute() {
		if (oper.equals(ConstType.ADD)) {
			return add();
		} else if (oper.equals(ConstType.DEL)) {
			return remove();
		} else if (oper.equals(ConstType.EDIT)) {
			return edit();
		}
		return ERROR;
	}

	private String remove() {
		return SUCCESS;
	}

	private String edit() {
		return SUCCESS;
	}

	private String add() {
		if (purcheseService.size() > ConstType.ZERO) {
			log.info("Submit Order first: "+getUser().getSmile().getSmileId());
		} else {
			Users u = null;
			try {
				u = purcheseService.userMember(getUser().getSmile().getSmileId());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			if (u == null) {
				 addActionError("Member Not Found  !!");
				 log.info(ConstType.MEMBER_NOT_FOUND+ getUser().getSmile().getSmileId());
			} else {
				log.info("Create Order :"+ getUser().getSmile().getSmileId());
				purcheseService.newOrder(u);
			}
		}
		return SUCCESS;
	}

	public EditOrderAct(PurcheseService purcheseService) {
		super();
		this.purcheseService = purcheseService;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

}
