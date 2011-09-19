package biz.evolix.action.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.dao.BranceDAO;
import biz.evolix.model.Brance;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class FetchBranceJSON extends ActionSupport {

	private static final long serialVersionUID = -2808613941250438494L;

	@Action(value = "/json-fetch-brance-member", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })
	public String execute() throws Exception {
		setBrances(new HashMap<String, String>());
		return SUCCESS;
	}

	public String getJSON() throws Exception {
		return SUCCESS;
	}

	private Map<String, String> brances;
//	private static Logger log = Logger.getLogger(FetchBranceJSON.class);
	private BranceDAO fetchBrance;

	public FetchBranceJSON(BranceDAO fetchBrance) {
		super();
		this.fetchBrance = fetchBrance;
		
	}

	public Map<String, String> getBrances() {
		return brances;
	}

	public void setBrances(Map<String, String> brances) {		
		List<Brance> l = fetchBrance.findAll();
		for (Brance b : l) {
			brances.put(b.getBName(), b.getBName());
		}
		this.brances = brances;
	}
}