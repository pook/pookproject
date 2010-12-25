package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Column;


@Entity
@NamedQuery(
		name="findAuthorities",
	    query="select A from Authorities A where A.user.userId =?1"
)
@Table(name = "AUTHORITIES")
public class Authorities implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUTH_ID")
	private Long authId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private Users user;

	@Column(name = "AUTHORITY", length = 50, nullable = false)
	private String authority;

	private static final long serialVersionUID = 1L;

	public Authorities() {
		super();
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
}
