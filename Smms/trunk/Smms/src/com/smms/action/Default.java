package com.smms.action;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
public class Default extends ActionSupport {

  
  private static final long serialVersionUID = -7308127326053089498L;
//private static final Log  log              = LogFactory.getLog(Login.class);
    
  @Action(value = "/default", results = {		 
    @Result(location = "default.jsp", name = "success")
  })
  public String execute() throws Exception
  {
      return SUCCESS;
  }
}