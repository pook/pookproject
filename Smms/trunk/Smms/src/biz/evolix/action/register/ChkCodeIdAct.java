package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.FindCodeIdService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
public class ChkCodeIdAct extends ActionSupport {
	
	private static final long serialVersionUID = 9054215510680621505L;
	@Action(value = "/chk-codeId-member", results = {
			@Result(name = "success", location = "echo/echo.jsp"),
			@Result(name = "error", location = "echo/echo.jsp")
	})			
	public String execute(){
		setEcho(findCodeIdService.find(getCodeIdentification())+"");
		return SUCCESS;
	}
	private String echo;
	private String codeIdentification;
	public String getEcho() {
		return echo;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	
	private FindCodeIdService findCodeIdService;
	public ChkCodeIdAct(FindCodeIdService findCodeIdService) {
		super();
		this.findCodeIdService = findCodeIdService;
	}
	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}
	public String getCodeIdentification() {
		return codeIdentification;
	}
	
	
}
