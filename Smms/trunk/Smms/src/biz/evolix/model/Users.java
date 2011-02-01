package biz.evolix.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "ckpasswd", query = "select U from Users U where U.node1.smileId=?1 and U.password=?2"),
	@NamedQuery(name = "finduser", query = "select U from Users U where U.node1.smileId =?1 "),
	@NamedQuery(name = "finduserByName", query = "select U from Users U where U.detail.name =?1 "),
	@NamedQuery(name = "finduserByDisplayName", query = "select U from Users U where U.node1.displayName =?1 "),
	@NamedQuery(name = "receivecardSize", query = "select count(0) from Users U where U.recivecard=false"),
	@NamedQuery(name = "receivecard", query = "select U from Users U where U.recivecard=false order by U.userId"),
	@NamedQuery(name = "userSize", query = "select count(0) from Users U "),
	@NamedQuery(name = "loadUser", query = "select U from Users U order by U.userId"),
	@NamedQuery(name = "findAllStaff", query = "select U from Users U,Authorities A where A.user=U and A.authority = ?1  "),
	@NamedQuery(name = "updateCard", query = "update Users U set recivecard=true where U.node1.displayName=?1"),
	@NamedQuery(name = "resetPassword", query = "update Users U set U.password=?1 where U.userId=?2"),
	@NamedQuery(name = "userdownlinesize", query = "select count(0) from Users U where U.node1.inviter=?1"),
	@NamedQuery(name = "loaddownline", query = "select U from Users U where U.node1.inviter=?1"),
	@NamedQuery(name = "findmaxregister", query = "select U.maxRegister from Users U where U.userId =?1"),
	@NamedQuery(name = "findquata", query = "select U.numberOfAccount from Users U where U.userId=?1"),	
	@NamedQuery(name = "nextquata", query = "select U.numberOfAccount from Users U where U.numberOfAccount=?1 and U.detail=?2")
	}
)
@Table(name = "USERS")
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.TABLE)
	@TableGenerator(name = "USER_SEQ", initialValue = 14024, allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "DETAIL_ID",referencedColumnName="DETAIL_ID")
	private SmileUsersDetails detail;
	@Column(name = "NUM_ACCOUNT")
	private Integer numberOfAccount = 0;
	@Column(name = "MAX_REGISTER")
	private Integer maxRegister = 0;
	@Column(name = "ENABLED")
	private Boolean enaebled = true;
	@Column(name = "BRANCE", length = 50)
	private String brance;
	@Column(name = "BRANCE_CARD", length = 50)
	private String branceCard;	
	@Column(name = "REV_CARD")
	private Boolean recivecard = false;
	@Column(name = "BONUS_TEAM")
	private Integer bonusTeam = 0;
	@Column(name = "BONUS_INV")
	private Integer bonusInv = 0;
	@Column(name = "BONUS_LAST")
	private Integer bonusLast = 0;
	@Column(name = "READED")
	private Boolean readed = false;
	@Column(name = "PASSWORD", length = 50)
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE")
	private Date date;
	@Column(name = "LST_TOTAL_SV")
	private Integer lstTotalSV = 0;
	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "TREE_ID", referencedColumnName = "TREE_ID"),
			@JoinColumn(name = "POS", referencedColumnName = "POS") })
	private Node1 node1;
	private Set<Authorities> authorities=new HashSet<Authorities>();

	public void setNode1(Node1 node1) {
		this.node1 = node1;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	public Node1 getNode1() {
		return node1;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getNumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(Integer numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	@JoinColumn(nullable=true)
	@OneToMany(mappedBy = "AUTH_ID", cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public Boolean getEnaebled() {
		return enaebled;
	}

	public void setEnaebled(Boolean enaebled) {
		this.enaebled = enaebled;
	}

	public String getBrance() {
		return brance;
	}

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getBranceCard() {
		return branceCard;
	}

	public void setBranceCard(String branceCard) {
		this.branceCard = branceCard;
	}

	public Boolean getRecivecard() {
		return recivecard;
	}

	public void setRecivecard(Boolean recivecard) {
		this.recivecard = recivecard;
	}

	public Integer getBonusTeam() {
		return bonusTeam;
	}

	public void setBonusTeam(Integer bonusTeam) {
		this.bonusTeam = bonusTeam;
	}

	public Integer getBonusInv() {
		return bonusInv;
	}

	public void setBonusInv(Integer bonusInv) {
		this.bonusInv = bonusInv;
	}

	public Integer getBonusLast() {
		return bonusLast;
	}

	public void setBonusLast(Integer bonusLast) {
		this.bonusLast = bonusLast;
	}

	public Boolean getReaded() {
		return readed;
	}

	public void setReaded(Boolean readed) {
		this.readed = readed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public void setDetail(SmileUsersDetails detail) {
		this.detail = detail;
	}

	public SmileUsersDetails getDetail() {
		return detail;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setMaxRegister(Integer maxRegister) {
		this.maxRegister = maxRegister;
	}

	public Integer getMaxRegister() {
		return maxRegister;
	}

	public void setLstTotalSV(Integer lstTotalSV) {
		this.lstTotalSV = lstTotalSV;
	}

	public Integer getLstTotalSV() {
		return lstTotalSV;
	}
	

}
