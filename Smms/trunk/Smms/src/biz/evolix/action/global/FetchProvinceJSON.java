package biz.evolix.action.global;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Province;
import biz.evolix.model.dao.ProvinceDAO;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class FetchProvinceJSON extends ActionSupport {
	
	private static final long serialVersionUID = -8722319895173252394L;
	@Action(value = "/json-fetch-province-member", results = {
			@Result(name = "success", type = "json"),
			@Result(name = "error", type = "json") })

	public String execute() throws Exception {
		setProvinces(new TreeMap<String,String>());
		return SUCCESS;
	}
	
	public void setProvinces(Map<String,String> provinces) {		
		List<Province>pv = fetchProvince.findAll();
		for(Province p:pv){
			provinces.put(p.getpCode(),p.getPname() );
		}
		this.provinces = provinces;
	}
	public Map<String,String> getProvinces() {
		return provinces;
	}
	
	public FetchProvinceJSON(ProvinceDAO fetchProvince) {
		super();
		this.fetchProvince = fetchProvince;
		
	}
	
	private  ProvinceDAO fetchProvince;
	private Map<String,String> provinces;
	private static Logger log = Logger.getLogger(FetchBranceJSON.class);
}
