package biz.evolix.action.role;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.bean.UserRoleBean;
import biz.evolix.service.sub.RoleService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class EditRoleAct extends ActionSupport {

	private static final long serialVersionUID = 185646116533940661L;
	private static Logger log = Logger.getLogger(EditRoleAct.class);

	@Action(value = "/edit-role1", results = { @Result(name = "success", location = "smmsrole.jsp") })
	public String execute() {
		if (getOper().equals(ConstType.EDIT))
			add();
		return SUCCESS;
	}

	private void add() {
		try {
			UserRoleBean ub = new UserRoleBean(Integer.parseInt(getId()), "",
					"", val(getAdmin()), val(getStaff()), val(getMember()),
					val(getAllow()), getTel());
			roleService.updateRole(ub);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private String oper;
	private String id;
	private String admin;
	private String staff;
	private String member;
	private String allow;
	private String tel;

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	private RoleService roleService;

	public EditRoleAct(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin() {
		return admin;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	private static boolean val(String arg) {
		return arg.equalsIgnoreCase("Yes");
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}
}
