package biz.evolix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorColumn;

@Entity
@NamedQuery(
		name="findAuthorities",
	    query="select A from Authorities A where A.user.userId =?1"
)
@Table(name = "AUTHORITIES")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
@DiscriminatorValue("M")
public class Authorities implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AUTH_ID")
	private Long authId;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private Users user;

	@Column(name = "AUTHORITY", length = 50, nullable = false)
	private String authority;

	@Column(name = "TYPE")
	private String type;
	private static final long serialVersionUID = 1L;

	public Authorities() {
		super();
	}

	/*
	 * @EmbeddedId
	 * 
	 * @AttributeOverrides({
	 * 
	 * @AttributeOverride(name="username",column=@Column(name="USERNAME")),
	 * 
	 * @AttributeOverride(name="password",column=@Column(name="PASSWORD")),
	 * 
	 * @AttributeOverride(name="inviter",column=@Column(name="INVITER")),
	 * 
	 * @AttributeOverride(name="enabled",column=@Column(name="ENABLED")) })
	 */

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

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
