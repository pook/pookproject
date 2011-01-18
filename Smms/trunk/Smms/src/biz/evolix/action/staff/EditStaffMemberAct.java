package biz.evolix.action.staff;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.service.sub.StaffMemberService;

import com.opensymphony.xwork2.ActionSupport;

public class EditStaffMemberAct extends ActionSupport {

	private static final long serialVersionUID = 8840061489143870880L;
	private static Logger log = Logger.getLogger(EditStaffMemberAct.class);

	@Action(value = "/edit-user-register-staff", results = { @Result(name = "success", location = "smmsrole.jsp") })
	public String execute() {
		if (getOper().equals(ConstType.EDIT))
			edit();
		return SUCCESS;
	}

	private void edit() {
		try {
			staffMemberService.updateMaxRegister(Integer.parseInt(getId()),
					Integer.parseInt(getMaxuser()));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getOper() {
		return oper;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	private StaffMemberService staffMemberService;
	private String oper, id, maxuser;

	public EditStaffMemberAct(StaffMemberService staffMemberService) {
		super();
		this.staffMemberService = staffMemberService;
	}

	public void setMaxuser(String maxuser) {
		this.maxuser = maxuser;
	}

	public String getMaxuser() {
		return maxuser;
	}

}
