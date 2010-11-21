package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class FetchUpline extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2403583800756482378L;

	@Action(value = "/json-fetch-upline", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		
		return SUCCESS;
	}

}
