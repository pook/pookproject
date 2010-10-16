package com.smms.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Organization extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7992937997674968155L;
	@Action(value = "/organization", results = { @Result(location = "onSuccess.jsp", name = "success") })
	public String execute() throws Exception {		
		return SUCCESS;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
