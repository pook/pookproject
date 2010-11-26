package biz.evolix.action.register;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Node1;
import biz.evolix.service.RegisterService;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")

public class FetchUpline extends ActionSupport {

	private Map<String,String>uplines =new HashMap<String,String>();
	private RegisterService registerService;
	private static final long serialVersionUID = 2403583800756482378L;

	@Action(value = "/json-fetch-upline", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {		
		return SUCCESS;
	}
	public String getJSON() throws Exception {
		Collection<Node1> c = registerService.listUpline();		
		for(Node1 n:c )uplines.put(n.getNId().toString(), n.getDisplayName());		
		return execute();
	}

	public FetchUpline(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	public Map<String, String> getUplines() {
		return uplines;
	}
	public void setUplines(Map<String, String> uplines) {
		this.uplines = uplines;
	}
}
