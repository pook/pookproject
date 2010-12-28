package biz.evolix.action.register;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import biz.evolix.model.Node1;
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.dao.CheckDNameDAO;
import biz.evolix.secure.SmileUser;
import biz.evolix.service.RegisterService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "smms")
@InterceptorRef("jsonValidationWorkflowStack")
public class Register extends ActionSupport {

	private static Logger log = Logger.getLogger(Register.class);
	private static final long serialVersionUID = -5490626071707862488L;

	private String name;
	private String surename;
	private String displayName;
	private String codeIdentification;
	private String tel;
	private String tel2;
	private String branceCard;
	private String email;
	private String address;
	private String province;
	private String address2;
	private String bank;
	private String bankBrance;
	private String bankAccount;
	private String brance;
	private String typeOfAccount;
	private String echo;
	private String upline;
	private RegisterService registerService;

	@Action(value = "/save", results = {
			@Result(location = "echo/error.jsp", name = "error"),
			@Result(location = "echo/success.jsp", name = "success") })
	public String execute() throws Exception {
		return save();
	}

	private String save() throws Exception {
		boolean ck = check();
		if (!ck) {
			log.info("brance :" + getBank());
			setEcho("true");
			addActionError("Bad Request !!");
			log.error("Bad request");
			return ERROR;
		} else {
			try {
				SmileUsersDetails user = new SmileUsersDetails();
				user.setBrance(getBrance());
				user.setBranceCard(getBranceCard());
				user.setAddress(getAddress());
				user.setAddress2(getAddress2());
				user.setBank(getBank());
				user.setBankAccount(getBankAccount());
				user.setBbrance(getBankBrance());
				user.setCodeIdentification(getCodeIdentification());
				user.setEmail(getEmail());
				user.setName(getName());
				user.setSurename(getSurename());
				user.setTel(getTel());
				user.setTel2(getTel2());
				user.setTypeOfAccount(getTypeOfAccount());
				Node1 n = new Node1();
				n.setInviter(getInviter());
				n.setDisplayName(getDisplayName());
				user = registerService
						.save(user, getUpline(), getProvince(), n);								
				setEcho("true");
				addActionMessage("Success !!");
				addActionMessage("Your user ID :" +  user.getSmileId());
			}catch(UsernameNotFoundException ue){
				addActionError("Register Fail !!");
				return ERROR;
			}catch (Exception e) {
				addActionError("Register Fail !!");
				return ERROR;
			}
		}
		return SUCCESS;
	}

	private boolean check() {
		boolean i = true;
		try {
			i = getAddress().trim().length() > 3;			
			i &= getBank().trim().length() > 3;			
			i &= getBankAccount().trim().length() > 3;
			i &= getBrance().trim().length() > 3;			
			i &= getBranceCard().trim().length() > 3;			
			i &= checkIdent(getCodeIdentification());			
			i &= getDisplayName().trim().length() > 2;			
			i &= getName().trim().length() > 2;			
			i &= getProvince().trim().length() > 1;			
			i &= getSurename().trim().length() > 2;			
			i &= (getTel().trim().length() > 8);			
			i &= checkDisplayName();			
			getEmail().length();
			getTel2().length();
			getAddress2().length();
		} catch (NullPointerException e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return i;
	}

	private boolean checkDisplayName() {
		return !checkNameDAO.test(getDisplayName());
	}

	private boolean checkIdent(String id) {
		if (id.length() != 13)
			return false;
		int sum = 0;
		for (int i = 0; i < 12; i++)
			sum += Float.parseFloat("" + id.charAt(i)) * (13 - i);
		if ((11 - sum % 11) % 10 != Float.parseFloat("" + id.charAt(12)))
			return false;
		return true;
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
		return (getUsers() == null) ? getDisplayName() : getUsers()
				.getDisplayName();
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

	private CheckDNameDAO checkNameDAO;

	public Register(RegisterService registerService, CheckDNameDAO checkNameDAO) {
		super();
		this.registerService = registerService;
		this.checkNameDAO = checkNameDAO;
	}

	public void setUpline(String upline) {
		this.upline = upline;
	}

	public String getUpline() {
		return upline;
	}

	public void setBankBrance(String bankBrance) {
		this.bankBrance = bankBrance;
	}

	public String getBankBrance() {
		return bankBrance;
	}

	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
