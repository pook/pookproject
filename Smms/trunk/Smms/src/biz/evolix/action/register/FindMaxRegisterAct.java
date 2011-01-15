package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.FindMaxRegisterService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
public class FindMaxRegisterAct extends ActionSupport {

	
	private static final long serialVersionUID = -9075195843434199810L;
	@Action(value = "/max-register", results = {
			@Result(name = "success", location = "echo/echo.jsp"),
			@Result(name = "error", location = "echo/echo.jsp")
	})			
	public String execute(){
		setEcho(findMaxRegisterService.max()+"");
		return SUCCESS;
	}
	public String echo;
	
	public String getEcho() {
		return echo;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}	
	private FindMaxRegisterService findMaxRegisterService;
	public FindMaxRegisterAct(FindMaxRegisterService findMaxRegisterService) {
		super();
		this.findMaxRegisterService = findMaxRegisterService;
	}
	
}
