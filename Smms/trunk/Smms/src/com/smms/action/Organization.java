package com.smms.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Node1;
import biz.evolix.service.OrchartService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Organization extends ActionSupport{// implements SessionAware{

	private OrchartService orchartService;
	
	private static final long serialVersionUID = -7992937997674968155L;
	@Action(value = "/organization", results = { @Result(location = "organization.jsp", name = "success") })
	public String execute() throws Exception {	
		System.out.println("....");
		List<Node1> ns=orchartService.getTeamLevel(1L);
		System.out.println(ns);
		System.out.println("ffff");
		System.out.println(orchartService.levelCommissions(ns));
		System.out.println("xxxx");
		return SUCCESS;
	}
	public Organization(OrchartService orchartService) {
		super();
		this.orchartService=orchartService;
	}	
}
