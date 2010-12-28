package com.smms.action;


import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.Users;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")public class Member extends ActionSupport {

	private static final long serialVersionUID = -2347337907533343919L;
	private String echo;
	private Users userModel ;
	private UsersDAO userDAO;
		
	public Users getUserModel() {
		return userModel;
	}

	public void setUserModel(Users userModel) {
		this.userModel = userModel;
	}

	@Action(value = "/json-member", results = { @Result(type ="json", name = "success") })
	public String execute() throws Exception {
		Users user = userDAO.find(getUsers().getUserid());				
		setUserModel(user);		
		return SUCCESS;
	}
	
	public void setEcho(String echo) {
		this.echo = echo;
	}

	public String getEcho() {
		return echo;
	}
	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}
		
	public Member(UsersDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	private static Logger log = Logger.getLogger(Member.class);
		
}