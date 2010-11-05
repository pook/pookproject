package com.smms.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.secure.SmileUser;

import com.opensymphony.xwork2.ActionSupport;

public class Commission extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7657873894220487780L;

	@Action(value = "/commission", results = { @Result(location = "commission.jsp", name = "success"),
	// @Result(location = "login.jsp", name = "error")
	})
	public String execute() throws Exception {
		try {
			
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
