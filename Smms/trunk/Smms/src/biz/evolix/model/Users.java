package biz.evolix.model;

import java.lang.String;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Table(name = "USERS")
@Cache (
     type=CacheType.WEAK,    
     size = 128,
     expiry=600000,
     alwaysRefresh=true,
     disableHits=true,
     coordinationType=CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS
     )
@NamedQueries({
		@NamedQuery(name = "ckpasswd", query = "select U from Users u where U.userId =?1 and U.password=?2")
})
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = -1086396230161064363L;
	@Id	
	@Column(name = "USER_ID", columnDefinition="CHAR(20)", unique = true)
	private String userId;
	@Column(name = "PASSWORD")
	private String password ;
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
	@Column(name = "ADDRESS",columnDefinition="TEXT(500)")
	private String address;
	@JoinColumn(name = "PROVINCE")
	private Province province;
	@Column(name = "ADDRESS2", columnDefinition="TEXT(500)")
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
	@Column(name ="BRANCE")
	private Integer brance;
	@Column(name ="BRANCE_CARD")
	private Integer branceCard;
	private List<Authorities> authorities;
	@Column(name="REV_CARD")
	private Boolean recivecard = false;
	//@OneToOne(mappedBy="nId")	
	@JoinColumn(name="NODE_ID")		
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

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	@OneToMany(mappedBy = "AUTH_ID", cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
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
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
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
	public void setRecivecard(Boolean recivecard) {
		this.recivecard = recivecard;
	}
	public Boolean getRecivecard() {
		return recivecard;
	}
	
}
