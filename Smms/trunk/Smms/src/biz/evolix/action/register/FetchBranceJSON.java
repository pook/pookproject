package biz.evolix.action.register;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Brance;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class FetchBranceJSON extends ActionSupport {

	private static final long serialVersionUID = 4284994485915941959L;
	
	@Action(value = "/json-fetch-brance", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {		
		return SUCCESS;
	}
	public String getJSON() throws Exception {
		return execute();
	}
	private Map<String,String> brances;
	private static Logger log = Logger.getLogger(FetchBranceJSON.class);
}	
