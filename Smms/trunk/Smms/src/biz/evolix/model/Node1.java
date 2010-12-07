package biz.evolix.model;

import biz.evolix.gen.Generate;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;

@Entity
@NamedQueries({
		@NamedQuery(name = "findDisplayName", query = "select N.nodeId from Node1 N where N.displayName=?1"),
		@NamedQuery(name = "findNode1FromUser", query = "select N from Node1 N where N.user=?1") })
@Table(name = "NODE1")
public class Node1 implements java.io.Serializable {

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nodeId;
	@Column(name = "DISPLAYNAME", length = 50)
	private String displayName;
	@Column(name = "USER_ID", columnDefinition = "CHAR(20)")	
	private String user;
	@Column(name = "SMILE_VALUE")
	private Integer sv = 0;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;
	@Column(name = "STATUS")
	private Character status = 'I';
	@Column(name = "INVITER", length = 50)
	private String inviter;

	public Node1() {
		super();
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

	@Transient
	public void decSv(Integer sv) {
		setSv(getSv() - sv);
	}

	@Transient
	public void incSv(Integer sv) {
		setSv(getSv() + sv);
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public Integer getCommissions() {
		return this.commissions + (int) Generate.xCommission(getSv());
	}

	public void setCommissions(Integer commissions) {
		this.commissions = commissions;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Character getStatus() {
		return status;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
	}

	public String getInviter() {
		return inviter;
	}

	/*
	 * @Override public int compareTo(Node1 o) { return ((int)(getNId()-o.nId));
	 * }
	 * 
	 * public boolean equals(Object other){ if(other instanceof Node1 ){ Node1 n
	 * = (Node1)other; return this.nId == n.nId; }
	 * 
	 * return false; }
	 */
}
