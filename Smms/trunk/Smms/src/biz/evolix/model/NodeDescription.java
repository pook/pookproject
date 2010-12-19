package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;

import biz.evolix.gen.Generate;

@Entity
@Table(name = "NODE_DEPT")
public class NodeDescription implements java.io.Serializable {

	private static final long serialVersionUID = -6853818182616308987L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nodeId = 0L;
	@Column(name = "NEXT_ID")
	private Long nextId = 1L;
	@Column(name = "UPPER")
	private Long upper = 1L;
	@Column(name = "LOWER")
	private Long lower = 1L;
	@Column(name = "LEVEL")
	private Integer level = 0;
	@Version
	@Column(name = "VERSION")
	private Integer version = 0;

	public NodeDescription() {
		super();
	}

	public NodeDescription(Long nodeId) {
		this();
		this.nodeId = nodeId;
		setLevel(1);
		setLower(Generate.getLeftChildId(nodeId));
		setUpper(getLower()+1);		
		setNextId(getLower());
	}

	public Long getNextId() {
		return nextId;
	}

	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}	

	public Long getUpper() {
		return upper;
	}

	public void setUpper(Long upper) {
		this.upper = upper;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getVersion() {
		return version;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setLower(Long lower) {
		this.lower = lower;
	}

	public Long getLower() {
		return lower;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

}
