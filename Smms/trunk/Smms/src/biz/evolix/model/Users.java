package biz.evolix.model;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = -1086396230161064363L;
	@Id	
	@Column(name = "USER_ID", length = 50, unique = true)
	private String userId;
	@Column(name = "PASSWORD")
	private String password ;
	@Column(name = "NAME", length = 50)
	private String name;
	@Column(name = "SURNAME", length = 50)
	private String surename;
	@Column(name = "CODE_IDENT", length = 50)
	private String codeIdentification;
	@Column(name = "TEL", length = 30)
	private String tel;
	@Column(name = "TEL2", length = 30)
	private String tel2;
	@Column(name = "INVITER", length = 50)
	private String inviter;
	@Column(name = "EMAIL", length = 50)
	private String email;
	@Column(name = "ADDRESS", length = 128)
	private String address;
	@Column(name = "PROVINCE", length = 50)
	private String province;
	@Column(name = "ADDRESS2", length = 128)
	private String address2;
	@Column(name = "BANK", length = 50)
	private String bank;
	@Column(name = "BANK_ACCOUNT", length = 50)
	private String bankAccount;
	@Column(name = "BANK_BRANCE", length = 50)
	private String bbrance;
	@Column(name = "TYPE_ACCOUNT", length = 50)
	private String typeOfAccount;
	@Column(name = "ENABLED")
	private Byte enaebled=(byte)1;
	@Column(name ="BRANCE",nullable = false)
	private Integer brance;
	@Column(name ="BRANCE_CARD",nullable = false)
	private Integer branceCard;
	private List<Authorities> authorities = new ArrayList<Authorities>();
	//@OneToOne(mappedBy="nId")	
	@JoinColumn(name="NODE_ID")	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Node1 node1;

	public Users() {
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

	public String getInviter() {
		return this.inviter;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
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

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
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

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(mappedBy = "AUTH_ID", cascade = CascadeType.PERSIST)
	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setEnaebled(Byte enaebled) {
		this.enaebled = enaebled;
	}
	public Byte getEnaebled() {
		return enaebled;
	}
	public void setNode1(Node1 node1) {
		this.node1 = node1;
	}
	
	public Node1 getNode1() {
		return node1;
	}
	public Integer getBrance() {
		return brance;
	}
	public void setBrance(Integer brance) {
		this.brance = brance;
	}
	public Integer getBranceCard() {
		return branceCard;
	}
	public void setBranceCard(Integer branceCard) {
		this.branceCard = branceCard;
	}
	
}