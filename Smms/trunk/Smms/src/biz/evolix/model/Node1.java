package biz.evolix.model;

import biz.evolix.customconst.ConstType;
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
		@NamedQuery(name = "findNode1FromUserId", query = "select N from Node1 N where N.user=?1") })
@Table(name = "NODE1")
public class Node1 implements java.io.Serializable {

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nodeId;
	@Column(name = "DISPLAYNAME", length = 50)
	private String displayName;
	@Column(name = "USER_ID")
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
		int v = getSv() - sv;
		if (v >= ConstType.MIN_SV && getStatus() == ConstType.STATUS_ACTIVE)
			setStatus(ConstType.STATUS_INACTIVE);
		setSv(v);
	}

	@Transient
	public void incSv(Integer sv) {
		int v = getSv() + sv;
		if (v >= ConstType.MIN_SV && getStatus() == ConstType.STATUS_INACTIVE)
			setStatus(ConstType.STATUS_ACTIVE);
		setSv(v);
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public Integer getCommissions() {
		int com =this.commissions+getSv();
		return (getStatus() == ConstType.STATUS_ACTIVE) ? com+ (int) Generate.xCommission(com) : com;
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

	public boolean equals(Object o) {
		if (o != null && o instanceof Node1) {
			Node1 that = (Node1) o;
			return this.nodeId.equals(that.nodeId)
					&& this.nodeId.equals(that.nodeId);
		} else {
			return false;
		}
	}

	public int hashCode() {
		int hash = 7;
	    hash = hash * 31 + this.nodeId.hashCode();
	    hash = hash * 31 
	                + (this.nodeId == null ? 0 : this.nodeId.hashCode());
	    return hash;

	}
}
