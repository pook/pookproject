package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Index extends ActionSupport {

	private static final long serialVersionUID = 3165479155466393173L;

	@Action(value = "/index", results = { @Result(location = "index.jsp", name = "success") })
	public String execute() throws Exception {
		return SUCCESS;
	}
}
