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
	@Action(value = "/edit-role1-admin", results = { @Result(name = "success", location = "smmsrole.jsp") })
	public String execute() {
		if (getOper().equals(ConstType.EDIT))
			edit();
		return SUCCESS;
	}

	private void edit() {	
		log.info(">>>>"+getAdmin()+">>>>>>>>>"+getStaff()+">>>>>>>>"+getMember());
		UserRoleBean ub = new UserRoleBean(Integer.parseInt(getId()),
				getName(), getSurename(), getBankAccount(), getBankBrance(),
				getAddress(), val(getAdmin()), val(getStaff()),
				val(getMember()), "");
		roleService.updateRole(ub);
	}

	private String oper;
	private String id;
	private String name;
	private String surename;
	private String bankAccount;
	private String bankBrance;
	private String address;
	private String admin;
	private String staff;
	private String member;
	private String tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankBrance() {
		return bankBrance;
	}

	public void setBankBrance(String bankBrance) {
		this.bankBrance = bankBrance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	private static boolean val(String arg) {
		return arg.equalsIgnoreCase("on")||arg.equalsIgnoreCase("Yes");
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

}
