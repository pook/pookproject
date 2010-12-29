package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;

import biz.evolix.gen.Generate;

@Entity
@IdClass(NodePK.class)
@NamedQueries({
		@NamedQuery(name = "findNonSpace", query = "select D.pos from NodeDescription D where  D.pos>=?1 and D.pos<=?2 " )
	})
@Table(name = "NODE_DEPT")
public class NodeDescription implements java.io.Serializable {

	private static final long serialVersionUID = -6853818182616308987L;
	@Id
	@Column(name = "TREE_ID", nullable = false, length =32,columnDefinition="CHAR(32)")
	private String treeId ;
	@Id
	@Column(name = "POS", nullable = false)
	private Long pos;
	@Column(name = "NEXT_ID")
	private Long nextId;
	@Column(name = "UPPER")
	private Long upper;
	@Column(name = "LOWER")
	private Long lower;
	@Column(name = "LEVEL")
	private Integer level = 0;
	@Column(name="HASH_CODE",columnDefinition="CHAR(32)",length=32)
	private String hashCode; 
	@Column(name ="COUNT")
	private Long count = 0L;
	@Version
	@Column(name = "VERSION")
	private Integer version = 0;
	@Column(name = "BASE_LEVEL")
	private Integer baseLevel= -1;
	public NodeDescription(long pos,String nodeId){
		super();
	}
	public NodeDescription(){
		super();
	}
	public NodeDescription(NodePK id) {		
		this(id.getTreeId(),id.getPos());
	}

	public NodeDescription(String nodeId, long pos) {
		super();
		this.treeId = nodeId;
		this.pos = pos;
		setLevel(1);
		setLower(Generate.left(this.pos));
		setUpper(Generate.right(this.pos));
		setNextId(getLower());
		setCount(0L);		
		setHashCode(new NodePK(getTreeId(), getPos()).hashNode1());
	}
	public NodeDescription(int baselevel,NodePK id){
		this(id);
		setBaseLevel(baselevel+getLevel());
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
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getCount() {
		return count;
	}
	public void setBaseLevel(Integer baseLevel) {
		this.baseLevel = baseLevel;
	}
	public Integer getBaseLevel() {
		return baseLevel;
	}
}
