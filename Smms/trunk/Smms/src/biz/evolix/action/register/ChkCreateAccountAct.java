package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.FindQuotaService;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
public class ChkCreateAccountAct extends ActionSupport{
	
	private static final long serialVersionUID = 6556325405518018902L;

	@Action(value = "/check-account-member", results = {
			@Result(name = "success", location = "echo/echo.jsp")
			 })
	public String execute() {
		setEcho(findQuotaService.quota()+"");
		return SUCCESS;
	}
	public void setEcho(String echo) {
		this.echo = echo;
	}
	public String getEcho() {
		return echo;
	}
	private FindQuotaService findQuotaService;
	private String echo;

	public ChkCreateAccountAct(FindQuotaService findQuotaService) {
		super();
		this.findQuotaService = findQuotaService;
	}
	

}
