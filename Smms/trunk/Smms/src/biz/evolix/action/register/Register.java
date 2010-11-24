package biz.evolix.action.register;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.service.RegisterService;

import com.opensymphony.xwork2.ActionSupport;

/*
 import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
 import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
 import com.opensymphony.xwork2.validator.annotations.Validations;
 import com.opensymphony.xwork2.validator.annotations.ValidatorType;
 */
@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
/*
 * @Validations(requiredStrings = {
 * 
 * @RequiredStringValidator(fieldName = "password", type = ValidatorType.FIELD,
 * message = "Password is required"),
 * 
 * @RequiredStringValidator(fieldName = "newpassword", type =
 * ValidatorType.FIELD, message = "New Password is required"),
 * 
 * @RequiredStringValidator(fieldName = "renewpassword", type =
 * ValidatorType.FIELD, message = "Re-New Password is required") }, expressions
 * = { @ExpressionValidator(expression = "newpassword!=renewpassword", message =
 * "Password miss match") })
 */
public class Register extends ActionSupport {

	private static final long serialVersionUID = -5490626071707862488L;
	private static final Long AUTO = -2L;
	
	private String name;
	private String surename;
	private String displayName;
	private String codeIdentification;
	private String tel;
	private String tel2;
	private String inviter;
	private String branceCard;
	private String email;
	private String address;
	private String province;
	private String address2;
	private String bank;
	private String bankAccount;
	private String brance;
	private String typeOfAccount;
	private String echo;

	private RegisterService registerService;

	@Action(value = "/register", results = {
			@Result(location = "register.jsp", name = "error"),
			@Result(location = "register.jsp", name = "success") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "/save", results = { @Result(location = "register.jsp", name = "success") })
	public String save() throws Exception {
		// System.out.println("xxx"+tel2);
		Users user =new Users();
		Node1 n = new Node1();
		n.setDisplayName(getDisplayName()+Math.random());		
		user.setAddress(getAddress());
		user.setAddress2(getAddress2());
		user.setBank(getBank());
		user.setBankAccount(getBankAccount());
		user.setPassword("b60d121b438a380c343d5ec3c2037564b82ffef3");
		user.setBrance(getBrance());
		user.setCodeIdentification(getCodeIdentification());
		user.setEmail(getEmail());
		user.setInviter(getInviter());
		user.setName(getName());		
		user.setProvince(getProvince());
		user.setSurename(getSurename());
		user.setTel(getTel());
		user.setTel2(getTel2());
		user.setTypeOfAccount(getTypeOfAccount());
		n.setUser(user);
		registerService.save(n,AUTO);		
		return execute();

	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

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

	public String getCodeIdentification() {
		return codeIdentification;
	}

	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getInviter() {
		return inviter;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBrance() {
		return brance;
	}

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setBranceCard(String branceCard) {
		this.branceCard = branceCard;
	}

	public String getBranceCard() {
		return branceCard;
	}

	public Register(RegisterService registerService) {
		super();
		this.registerService=registerService;
	}

	
}
