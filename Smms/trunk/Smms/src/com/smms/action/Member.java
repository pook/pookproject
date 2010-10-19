package com.smms.action;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class Member extends ActionSupport {

	private static final long serialVersionUID = -2347337907533343919L;
	private Map<String,String>memb ;
	private String            echo;


	@Action(value = "/member", results = { @Result(location = "member.jsp", name = "success") })
	public String execute() throws Exception {	
		memb = new LinkedHashMap<String, String>();
		memb.put("รหัสสมาชิก :  ","X999999999999" );
		memb.put("ชื่อ :", "xxxxxxxxx");
		memb.put("นามสกุล :", "xxxxxxxxx");
		memb.put("รหัสบัตรประชาชน :     ", "99999999999");
		memb.put("E-mail :", "xxx@xxx.xxx");
		memb.put("Tel  :", "999-9999-999");
		memb.put("Commision :", "999.99");		
		memb.put("TotalPV","xxx");
		return SUCCESS;
	}

	public Map<String, String> getMemb() {
		return memb;
	}

	public void setMemb(Map<String, String> memb) {
		this.memb = memb;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

	public String getEcho() {
		return echo;
	}
	
}