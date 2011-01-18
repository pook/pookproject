package biz.evolix.model.bean;

import java.util.Date;

public class UserRoleBean extends User{	
		
	public UserRoleBean(Integer id, String name,
			String surename, String bankAccount,
			String bankBrance, String address, Boolean admin, Boolean staff,
			Boolean member, String tel) {
		super();
		setId(id);
		setName(name);	
		this.surename = surename;
		this.bankAccount = bankAccount;
		this.bankBrance = bankBrance;
		this.address = address;
		this.admin = admin;
		this.staff = staff;
		this.member = member;
		this.tel = tel;	
	}
	public UserRoleBean(Integer id, String smileId, String name,
			String displayName, String surename, String bankAccount,
			String bankBrance, String address, String tel, Date date) {
		super(id, smileId, name, displayName);
		this.surename = surename;
		this.bankAccount = bankAccount;
		this.bankBrance = bankBrance;
		this.address = address;		
		this.tel = tel;
		this.date = date;
	}
	private String surename;
	private String bankAccount;
	private String bankBrance;
	private String address;
	private Boolean admin = false,staff = false,member = false;
	private String tel;
	private Date date;
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean getStaff() {
		return staff;
	}
	public void setStaff(Boolean staff) {
		this.staff = staff;
	}
	public Boolean getMember() {
		return member;
	}
	public void setMember(Boolean member) {
		this.member = member;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getSurename() {
		return surename;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankBrance(String bankBrance) {
		this.bankBrance = bankBrance;
	}
	public String getBankBrance() {
		return bankBrance;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
}
