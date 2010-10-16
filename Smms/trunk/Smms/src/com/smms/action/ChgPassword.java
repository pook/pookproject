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
    @RequiredStringValidator(fieldName = "passwd", type = ValidatorType.FIELD, message = "Password is required"), 
    @RequiredStringValidator(fieldName = "newPasswd", type = ValidatorType.FIELD, message = "New Password is required"),
    @RequiredStringValidator(fieldName = "reNewPasswd", type = ValidatorType.FIELD, message = "Re New Password is required")
}, expressions = {
  @ExpressionValidator(expression = "newPasswd.trim().equals(reNewPasswd) == true", message = "New Password Not Match"), 
 
})

public class ChgPassword extends ActionSupport {

	private static final long serialVersionUID = 4069423852317948448L;
	@Action(value = "/chgPassword", results = {
		    @Result(location = "chgSuccess.jsp", name = "success")
		  })
	public String execute() throws Exception {
		echo = "Hello ";
		return SUCCESS;
	}
	
	public String getEcho() {
		return echo;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNewPasswd() {
		return newPasswd;
	}
	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
	public String getReNewPasswd() {
		return reNewPasswd;
	}
	public void setReNewPasswd(String reNewPasswd) {
		this.reNewPasswd = reNewPasswd;
	}

	private String echo;
	private String passwd;
	private String newPasswd;
	private String reNewPasswd;
}
