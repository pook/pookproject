package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
		@RequiredStringValidator(fieldName = "password", type = ValidatorType.FIELD, message = "Password is required"),
		@RequiredStringValidator(fieldName = "newpassword", type = ValidatorType.FIELD, message = "New Password is required"),
		@RequiredStringValidator(fieldName = "renewpassword", type = ValidatorType.FIELD, message = "Re-New Password is required") }
, expressions = { @ExpressionValidator(expression = "newpassword.equals(renewpassword)==true"
	, message = "Password miss match") 
		}
)
public class Chgpassword extends ActionSupport {
	private static final long serialVersionUID = -889030974105052644L;
	private String password;
	private String newpassword;
	private String renewpassword;
	private String echo;

	@Action(value = "/chgpassword", results = {
			@Result(location = "chgpassword.jsp", name = "error"),
			@Result(location = "onSuccess.jsp", name = "success") })
	public String execute() throws Exception {
		echo = "xxxx";
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRenewpassword() {
		return renewpassword;
	}

	public void setRenewpassword(String renewpassword) {
		this.renewpassword = renewpassword;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}	
}
