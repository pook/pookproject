package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;

import biz.evolix.gen.Generate;

@Entity
@IdClass(NodePK.class)
@Table(name = "NODE_DEPT")
public class NodeDescription implements java.io.Serializable {

	private static final long serialVersionUID = -6853818182616308987L;
	@Id
	@Column(name = "TREE_ID", nullable = false, length =32,columnDefinition="CHAR(32)")
	private String treeId ;
	@Id
	@Column(name = "POS", nullable = false)
	private Long pos;
	@Column(name = "NEXT_ID", length = 50)
	private Long nextId;
	@Column(name = "UPPER", length = 50)
	private Long upper;
	@Column(name = "LOWER", length = 50)
	private Long lower;
	@Column(name = "LEVEL")
	private Integer level = 0;
	@Column(name="HASH_CODE",columnDefinition="CHAR(32)",length=32)
	private String hashCode;
	@Version
	@Column(name = "VERSION")
	private Integer version = 0;

	public NodeDescription() {
		super();
	}

	public NodeDescription(NodePK pk) {		
		this(pk.getTreeId(),pk.getPos());
	}

	public NodeDescription(String nodeId, Long pos) {
		super();
		this.treeId = nodeId;
		this.pos = pos;
		setLevel(1);
		setLower(Generate.left(this.pos));
		setUpper(Generate.right(this.pos));
		setNextId(getLower());
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}

	public Long getPos() {
		return pos;
	}

	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}

	public Long getNextId() {
		return nextId;
	}

	public void setUpper(Long upper) {
		this.upper = upper;
	}

	public Long getUpper() {
		return upper;
	}

	public void setLower(Long lower) {
		this.lower = lower;
	}

	public Long getLower() {
		return lower;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getHashCode() {
		return hashCode;
	}
}
