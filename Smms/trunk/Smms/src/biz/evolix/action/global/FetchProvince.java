package biz.evolix.action.global;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Province;
import biz.evolix.model.dao.ProvinceDAO;
import biz.evolix.utils.Comapare;

import com.opensymphony.xwork2.ActionSupport;

public class FetchProvince extends ActionSupport{

	private static final long serialVersionUID = -4397811867097445251L;
	@Action(value = "/fetch-province-member", results = {
			@Result(location = "select-province.jsp", name = "success")})
	public String execute() throws Exception {
		setProvinces(new TreeMap<String,String>(new Comapare<String>()));
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
	private  ProvinceDAO fetchProvince;
	private Map<String,String> provinces;
	public FetchProvince(ProvinceDAO fetchProvince) {
		super();
		this.fetchProvince = fetchProvince;
		
	}}
