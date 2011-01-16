package biz.evolix.action.role;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.service.sub.RoleService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")

public class EditCardManAct extends ActionSupport {

	private static Logger log = Logger.getLogger(EditCardManAct.class);
	private static final long serialVersionUID = 3896887071573358570L;
	@Action(value = "/edit-card", results = {
			@Result(location = "smmsrole.jsp", name = "success"),
			@Result(location = "smmsrole.jsp", name = "input") })
	public String execute() throws Exception {
		roleService.updateCard(getRows());		
		return SUCCESS;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getRows() {
		return rows;
	}
	private String rows;
	private RoleService roleService;
	public EditCardManAct(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
}
