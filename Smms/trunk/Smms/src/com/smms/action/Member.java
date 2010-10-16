package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class Member extends ActionSupport {

	private static final long serialVersionUID = -2347337907533343919L;

	@Action(value = "/member", results = { @Result(location = "onSuccess.jsp", name = "success") })
	public String execute() throws Exception {		
		return SUCCESS;
	}
}