package com.smms.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


import com.opensymphony.xwork2.ActionSupport;

public class Commission extends ActionSupport {
	
    private static Logger log = Logger.getLogger(Commission.class);

	private static final long serialVersionUID = 7657873894220487780L;

	@Action(value = "/commission", results = { @Result(location = "commission.jsp", name = "success"),
	// @Result(location = "login.jsp", name = "error")
	})
	public String execute() throws Exception {
		try {
			log.info("Hello loger");
			System.out.println("hello loger");
//			System.out.println("vvv");
//				SmileUser u = (SmileUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("node>>>>>>>>>>>>>>>>>>>>"
//				+ u.getNode().getNId());

		} catch (Exception e) {
			System.err.println(e);
		}

		return SUCCESS;
	}
}
