package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;
@Entity
@Table(name = "NODE_DEPT")
public class NodeDescription implements java.io.Serializable {

	private static final long serialVersionUID = -6853818182616308987L;
	@Id
	@Column(name = "LEVEL", length = 20)
	private String levelId;
	
	@Column(name = "NEXT_ID")
	private Long nextId=2L;
	@Column(name = "MAX_NODE")
	private int maxNode=1;
	@Column(name = "COUNT")
	private int count=0;
	@Column(name = "UPPER")
	private Long upper=1L;

	@Version
	@Column(name="VERSION")
	private Integer version;
	
	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Long getNextId() {
		return nextId;
	}

	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}

	public int getMaxNode() {
		return maxNode;
	}

	public void setMaxNode(int maxNode) {
		this.maxNode = maxNode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

}
