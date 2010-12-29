package biz.evolix.model;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "USERS_DETAIL")
public class SmileUsersDetails implements java.io.Serializable {

	private static final long serialVersionUID = -1086396230161064363L;
	@Id
	@Column(name = "SMILE_ID", columnDefinition = "CHAR(50)", unique = true)
	private String smileId;	
	@Column(name = "NAME", length = 50)
	private String name;
	@Column(name = "SURNAME", length = 50)
	private String surename;
	@Column(name = "CODE_IDENT", length = 30)
	private String codeIdentification;
	@Column(name = "TEL", length = 30)
	private String tel;
	@Column(name = "TEL2", length = 30)
	private String tel2;
	@Column(name = "EMAIL", length = 100)
	private String email;
	@Column(name = "ADDRESS", columnDefinition = "TEXT(500)")
	private String address;
	@JoinColumn(name = "PROVINCE")
	private Province province;
	@Column(name = "ADDRESS2", columnDefinition = "TEXT(500)")
	private String address2;
	@Column(name = "BANK", length = 50)
	private String bank;
	@Column(name = "BANK_ACCOUNT", length = 50)
	private String bankAccount;
	@Column(name = "BANK_BRANCE", length = 50)
	private String bbrance;
	@Column(name = "TYPE_ACCOUNT", length = 50)
	private String typeOfAccount;
	

	
	public SmileUsersDetails() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurename() {
		return this.surename;
	}

	public void setSurename(String surename) {
		this.surename = surename;
	}

	public String getCodeIdentification() {
		return this.codeIdentification;
	}

	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBbrance() {
		return this.bbrance;
	}

	public void setBbrance(String bbrance) {
		this.bbrance = bbrance;
	}

	public String getTypeOfAccount() {
		return this.typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}
	
	public void setSmileId(String smileId) {
		this.smileId = smileId;
	}

	public String getSmileId() {
		return smileId;
	}

}
