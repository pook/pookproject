package biz.evolix.action.register;


import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.FetchUplineService;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class FetchUpline extends ActionSupport {

	private Map<String,String>uplines =new HashMap<String,String>();
	private FetchUplineService fetchUplineService;
	private static final long serialVersionUID = 2403583800756482378L;

	@Action(value = "/json-fetch-upline", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {		
		return SUCCESS;
	}
	public String getJSON() throws Exception {
		uplines = fetchUplineService.uplines();	
		return execute();
	}

	public FetchUpline(FetchUplineService fetchUplineService) {
		super();
		this.fetchUplineService = fetchUplineService;
	}
	public Map<String, String> getUplines() {
		return uplines;
	}
	public void setUplines(Map<String, String> uplines) {
		this.uplines = uplines;
	}
}
