package biz.evolix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
/**
 * Entity implementation class for Entity: Staff
 * 
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "staffsize", query = "select count(0) from Staff S"),
	@NamedQuery(name = "updatestaff", query = "update Staff S  set brance =?1 where S.brance =?2 ")
})
@Table(name = "STAFF")
public class Staff implements java.io.Serializable {

	@Id
	@Column(name = "USER_ID")	
	private Long userId;

	@Column(name = "BRANCE_CODE", length = 50)
	private String brance;
	private static final long serialVersionUID = 1L;

	public Staff() {
		super();
	}
	

	public Staff(Long userId, String brance) {
		super();
		this.userId = userId;
		this.brance = brance;
	}


	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getBrance() {
		return brance;
	}		
}
