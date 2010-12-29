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
@NamedQueries({ @NamedQuery(name = "ckpasswd", query = "select U from Users u where UPPER(U.smile) =?1 and U.password=?2"),
	@NamedQuery(name = "loaduser", query = "select U from Users u where U.smile.smileId =?1 ")
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
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SMILE_ID",referencedColumnName="SMILE_ID")
	private SmileUsersDetails smile;
	@Column(name = "NUM_ACCOUNT")
	private Integer numberOfAccount = 0;

	@Column(name = "ENABLED")
	private Byte enaebled = (byte) 1;
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

	@OneToMany(mappedBy = "AUTH_ID", cascade = CascadeType.PERSIST)
	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setSmile(SmileUsersDetails smile) {
		this.smile = smile;
	}

	public SmileUsersDetails getSmile() {
		return smile;
	}

	public Byte getEnaebled() {
		return enaebled;
	}

	public void setEnaebled(Byte enaebled) {
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
	

}
