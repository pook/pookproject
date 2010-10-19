package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Organization extends ActionSupport{// implements SessionAware{

	private static final long serialVersionUID = -7992937997674968155L;
	@Action(value = "/organization", results = { @Result(location = "organization.jsp", name = "success") })
	public String execute() throws Exception {		
		return SUCCESS;
	}


	
}
