package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class Commission extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7657873894220487780L;

	@Action(value = "/commission", results = {		 
		    @Result(location = "commission.jsp", name = "success"),
		//    @Result(location = "login.jsp", name = "error")
		  })
		  public String execute() throws Exception
		  {
		      return SUCCESS;
		  }

}
