package com.smms.action;

import java.util.LinkedHashMap;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class Member extends ActionSupport {

	private static final long serialVersionUID = -2347337907533343919L;
	private String echo;
	private String uid;
	private String card;
	private String name;
	private String tel;
	private String btel;
	private String fax;
	private String email;
	private String commision;
	private String totalPV;
	private String bookBank;	
	private String account;
	private String accountId;
	private String bankBrance;
	private String bankType;
	private String username;
	
	
	private Map<String,String> memb;
	public Map<String, String> getMemb() {
		return memb;
	}

	public void setMemb(Map<String, String> memb) {
		this.memb = memb;
	}

	public Map<String, String> getMemb2() {
		return memb2;
	}

	public void setMemb2(Map<String, String> memb2) {
		this.memb2 = memb2;
	}

	private Map<String,String> memb2;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Action(value = "/member", results = { @Result(location = "member.jsp", name = "success") })
	public String execute() throws Exception {	
		
		memb = new LinkedHashMap<String, String>();
		memb.put("รหัสสมาชิก :  ","X999999999999 " );
		memb.put("รหัสบัตรประชาชน :     ", "99999999999");
		memb.put("ชื่อ :", "xxxxxxxxx");
		memb.put("นามสกุล :", "xxxxxxxxx");
		memb.put("เบอร์โทรศัพท์  :", "999-9999-999");
		memb.put("เบอร์โทรศัพท์มือถือ", "999-9999-999");
		memb.put("เบอร์แฟกส์", "99-9999-99");
		memb.put("E-mail :", "xxx@xxx.xxx");		
		memb.put("ที่อยู่", "xxxxxxxxxxxxxxxxxxxxxxx");
		memb.put("ที่อยู่ส่งของ :", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");	
		memb.put("บัญชีธนาคาร", "xxxxxxxxxxxxxxxxxxxxxx");
		memb2 = new LinkedHashMap<String, String>();
		memb2.put("บัญชี :", "xxxxxxxxxxxxxxx");
		memb2.put("เลขบัญชี :", "99999999999999999");
		memb2.put("สาขาบัญชี :", "xxxxxxxxxxxxxx");
		memb2.put("ประเภทบัญชี :", "xxxxxxxxxxxxxx");
		memb2.put("งานครั้งล่าสุด :","xxx");
		memb2.put("point value :","99.99");
		memb2.put("total point value :","99.99");
		this.account="xxxxxxxxxx";
		this.accountId="9999999999999";
		this.bankBrance="xxxxxxxxxxxxxx";
		this.bankType="xxxxxxxxxxxx";
		this.bookBank="xxxxxxxxxxxxx";
		this.btel="999-9999-999";
		this.card = "9999999999999";
		this.commision = "999.99";
		this.email="xxx@xxx.xxx";
		this.fax = "99-9999-999";
		this.tel="99-9999-999";
		this.totalPV="999";		
		this.username="xxxxx";
		this.name ="xxxxxxxxxxxxx xxxxxxxxxxxxxxx"; 
		return SUCCESS;
	}
	
	public void setEcho(String echo) {
		this.echo = echo;
	}

	public String getEcho() {
		return echo;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBtel() {
		return btel;
	}

	public void setBtel(String btel) {
		this.btel = btel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommision() {
		return commision;
	}

	public void setCommision(String commision) {
		this.commision = commision;
	}

	public String getTotalPV() {
		return totalPV;
	}

	public void setTotalPV(String totalPV) {
		this.totalPV = totalPV;
	}

	public String getBookBank() {
		return bookBank;
	}

	public void setBookBank(String bookBank) {
		this.bookBank = bookBank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBankBrance() {
		return bankBrance;
	}

	public void setBankBrance(String bankBrance) {
		this.bankBrance = bankBrance;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	
	
		
}