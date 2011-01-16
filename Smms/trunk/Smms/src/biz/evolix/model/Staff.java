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
	@NamedQuery(name = "staffsize", query = "select count(0) from Staff S")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 101;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}	
	
}
