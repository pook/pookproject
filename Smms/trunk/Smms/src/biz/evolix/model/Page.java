package biz.evolix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "lookup", query = "select P.value from Page P where P.key =?1"),
		@NamedQuery(name = "findLevel", query = "select P.level from Page P where P.key =?1") })
@Table(name = "PAGE")
public class Page implements java.io.Serializable {

	@Id
	@Column(name = "`KEY`", columnDefinition = "CHAR(32)")
	private String key;
	@Column(name = "VALUE", columnDefinition = "CHAR(32)")
	private String value = null;
	@Column(name = "LEVEL")
	private Integer level = 1;
	private static final long serialVersionUID = 1L;

	public Page() {
		super();
	}
	
	public Page(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
