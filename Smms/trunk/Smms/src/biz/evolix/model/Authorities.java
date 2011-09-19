package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

@Entity
@NamedQueries({
		@NamedQuery(name = "findAuthorities", query = "select A from Authorities A where A.user.userId =?1"),
		@NamedQuery(name = "findAuthorities2", query = "select A from Authorities A where A.user.userId =?1 and A.authority =?2"),		
		@NamedQuery(name = "findAuthoritiesByName", query = "select A from Authorities A where A.authority=?1 and A.user=?2"),
		@NamedQuery(name = "removeAuthorities", query = "delete from Authorities A where A.user.userId =?1") })
@Table(name = "AUTHORITIES")
public class Authorities implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTH_ID")
	private Long authId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@Column(name = "AUTHORITY", length = 50, nullable = false)
	private String authority;

	private static final long serialVersionUID = 1L;
 
	public Authorities() {
		super();
	}	

	public Authorities(String authority) {
		super();
		this.authority = authority;
	}

	public Authorities(Users user, String authority) {
		super();
		this.user = user;
		this.authority = authority;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Long getAuthId() {
		return authId;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
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
		Authorities other = (Authorities) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		return true;
	}	
}