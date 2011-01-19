package biz.evolix.action.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Brance;
import biz.evolix.model.dao.BranceDAO;

import com.opensymphony.xwork2.ActionSupport;

public class FetchBrance extends ActionSupport{	
	
	private static final long serialVersionUID = 7083132476280971282L;

	@Action(value = "/fetch-brance-member", results = {
			@Result(location = "select-brance.jsp", name = "success")})
	public String execute() throws Exception {		
		setBrances(new HashMap<String, String>());
		return SUCCESS;
		
	}
	private BranceDAO fetchBrance;
	private Map<String,String> brances;

	public FetchBrance(BranceDAO fetchBrance) {
		super();
		this.fetchBrance = fetchBrance;
	}

	public void setBrances(Map<String,String> brances) {
		List<Brance> l = fetchBrance.findAll();		
		for (Brance b : l) {
			brances.put(b.getBName(), b.getBName());
		}
		this.brances = brances;
	}

	public Map<String,String> getBrances() {
		return brances;
	}	
}
