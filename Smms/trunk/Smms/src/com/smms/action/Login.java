package com.smms.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.smms.service.SmmsService;
import com.smms.service.SmmsServiceImp;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = {
		@RequiredStringValidator(fieldName = "loginuser", type = ValidatorType.FIELD, message = "Login User is required"),
		@RequiredStringValidator(fieldName = "loginpassword", type = ValidatorType.FIELD, message = "Password is required") })
public class Login extends ActionSupport {

	private String loginuser;
	private String loginpassword;
	private String echo;
	private static final long serialVersionUID = 8163050753941197229L;

	@Action(value = "/login", results = { @Result(location = "onSuccess.jsp", name = "success")
		//	,@Result(location = "onSuccess.jsp", name = "success")
			})
	public String execute() throws Exception {
		SmmsService s = new SmmsServiceImp();
		boolean b=s.authentication(loginuser, loginpassword);
				echo = "Welcome " + loginuser+"So Happy  "+b;		
		return SUCCESS;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getLoginpassword() {
		return loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}
	

}
