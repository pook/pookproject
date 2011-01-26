package biz.evolix.action.role;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.service.StaffService;

import com.opensymphony.xwork2.ActionSupport;

public class EditStaffAct extends ActionSupport{

	private static final long serialVersionUID = -9032984422720912160L;
	@Action(value = "/edit-stff-admin", results = { @Result(name = "success", location = "smmsrole.jsp") })
	public String execute() {
		if (getOper().equals(ConstType.EDIT))
			edit();
		return SUCCESS;
	}
	private String oper;
	private String id;
	private String brance;
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	private void edit(){		
		staffService.editBrance(Integer.parseInt(getId()), getBrance());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrance() {
		return brance;
	}
	public void setBrance(String brance) {
		this.brance = brance;
	}
	private StaffService staffService;
	public EditStaffAct(StaffService staffService) {
		super();
		this.staffService = staffService;
	}	
}
