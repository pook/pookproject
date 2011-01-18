package biz.evolix.action.role;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.sub.RoleService;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswdAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622495338803920907L;
	@Action(value = "/resetpasswd-admin", results = {
			@Result(location = "smmsrole.jsp", name = "success"),
			@Result(location = "smmsrole.jsp", name = "input") })
	public String execute() throws Exception {
		roleService.resetPasswd(getRows());	
		return SUCCESS;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getRows() {
		return rows;
	}
	private RoleService roleService;
	private String rows;
	public ResetPasswdAct(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
	
	
}
