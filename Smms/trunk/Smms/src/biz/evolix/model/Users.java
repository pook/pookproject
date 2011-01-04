package biz.evolix.model;

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

@Entity
@NamedQueries({ @NamedQuery(name = "ckpasswd", query = "select U from Users U where U.smile=?1 and U.password=?2"),
	@NamedQuery(name = "finduser", query = "select U from Users U where U.node1.smileId =?1 "),
	@NamedQuery(name = "receivecardSize", query = "select count(U) from Users U where U.recivecard=false"),
	@NamedQuery(name = "receivecard", query = "select U from Users U where U.recivecard=false"),
	@NamedQuery(name = "userSize", query = "select count(U) from Users U "),
	@NamedQuery(name = "loadUser", query = "select U from Users U "),
	@NamedQuery(name = "updateCard", query = "update Users set recivecard=true where userId=?1"),
	@NamedQuery(name = "userdownlinesize", query = "select count(U) from Users U where U.node1.inviter=?1"),
	@NamedQuery(name = "loaddownline", query = "select U from Users U where U.node1.inviter=?1")
	}
)
@Table(name = "USERS")
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.TABLE)
	@TableGenerator(name = "USER_SEQ", initialValue = 10024, allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	@ManyToOne(cascade ={ CascadeType.PERSIST})
	@JoinColumn(name = "SMILE_ID",referencedColumnName="SMILE_ID")
	private SmileUsersDetails smile;
	@Column(name = "NUM_ACCOUNT")
	private Integer numberOfAccount = 0;

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
	@OneToMany(mappedBy = "AUTH_ID", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setSmile(SmileUsersDetails smile) {
		this.smile = smile;
	}

	public SmileUsersDetails getSmile() {
		return smile;
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
	

}
