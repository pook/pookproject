package com.smms.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class SmmsRole extends ActionSupport {
		private static final long serialVersionUID = 7213592453906175834L;

	@Action(value = "/jsonsmmsrole", results = { @Result(name = "success",location="smmsrole.jsp") })
	public String execute() throws Exception {		
		return SUCCESS;
	}
}