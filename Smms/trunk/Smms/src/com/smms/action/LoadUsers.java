package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class LoadUsers extends ActionSupport {

	private static final long serialVersionUID = -5921705957873163884L;
	private Users user;
	private String userId;
	private AuthoritiesDAO authoritiesDAO;

	@Action(value = "/jsonloaduser", results = { @Result(name = "success", type = "json") })
	public String execute() throws Exception {
		user =  authoritiesDAO.findUser(userId);
		return SUCCESS;
	}
	public String getJSON()throws Exception{
		return execute();
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getUser() {
		return user;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LoadUsers(AuthoritiesDAO authoritiesDAO) {
		super();
		this.authoritiesDAO = authoritiesDAO;
	}
	
}
