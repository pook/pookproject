package biz.evolix.model;

import biz.evolix.model.Users;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Node1
 * 
 */
@Entity
@Table(name = "NODE1")
public class Node1 implements java.io.Serializable {

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nId;
	@Column(name = "DISPLAYNAME", nullable = false, unique = true)
	private String displayName;

	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private Users user;

	@Column(name = "SMILE_VALUE", updatable = true)
	private Integer sv = 0;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;

	public Node1() {
		super();
	}

	public Long getNId() {
		return this.nId;
	}

	public void setNId(Long nId) {
		this.nId = nId;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getSv() {
		return this.sv;
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public Integer getCommissions() {
		return this.commissions;
	}

	public void setCommissions(Integer commissions) {
		this.commissions = commissions;
	}

	public void setUser(Users user) {
		this.user = user;
	}
//	@Basic(fetch=FetchType.EAGER)
	public Users getUser() {
		return user;
	}

	public String toString() {
		return getNId() + " " + getDisplayName() + "  " + getCommissions();
	}
}
