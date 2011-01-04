package biz.evolix.model;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

@Entity
@Cache(type = CacheType.WEAK, size = 128, expiry = 600000, alwaysRefresh = true, disableHits = true, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS)
@NamedQueries({		
		@NamedQuery(name = "findDisplayName", query = "select N from Node1 N where N.displayName=?1"),
		@NamedQuery(name = "findDisplayNameByPos", query = "select N.displayName from Node1 N where N.pos=?1"),
		@NamedQuery(name = "findNode1FromUserId", query = "select N from Node1 N where N.user=?1"),
		@NamedQuery(name = "findFromSmileId", query = "select N from Node1 N where N.smileId=?1"),
		@NamedQuery(name = "findByHashcode", query = "select N from Node1 N,NodeDescription D where N.treeId = D.treeId and "
				+ "N.pos = D.pos and D.hashCode =?1") })
@IdClass(NodePK.class)
@Table(name = "NODE1")
public class Node1 implements java.io.Serializable {

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "TREE_ID", nullable = false, length = 32, columnDefinition = "CHAR(32)")
	private String treeId;

	@Override
	public int hashCode() {
		final int p = 31;
		int r = 1;
		r = p * r + ((treeId == null) ? 0 : treeId.hashCode());
		r = p * r + ((pos == null) ? 0 : pos.hashCode());
		return r;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node1 other = (Node1) obj;
		if (treeId == null) {
			if (other.treeId != null)
				return false;
		} else if (!treeId.equals(other.getTreeId()))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.getPos()))
			return false;
		return true;
	}
	@Id
	@Column(name = "POS", nullable = false)
	private Long pos;
	@Column(name = "DISPLAYNAME", length = 50, unique = true)
	private String displayName;
	@Column(name = "USER_ID")
	private Long user;
	@Column(name = "SMILE_VALUE")
	private Integer sv = 0;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;
	@Column(name = "STATUS")
	private Character status = 'I';
	@Column(name = "INVITER", length = 50)
	private String inviter;
	@Column(name = "SMILE_ID", length = 50)
	private String smileId;

	public Node1() {
		super();
	}

	public Node1(NodePK id) {
		this();
		this.treeId = id.getTreeId();
		this.pos = id.getPos();
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

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getUser() {
		return user;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
	}

	public String getInviter() {
		return inviter;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}

	public Long getPos() {
		return pos;
	}

	public void setSmileId(String smileId) {
		this.smileId = smileId;
	}

	public String getSmileId() {
		return smileId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}

}
