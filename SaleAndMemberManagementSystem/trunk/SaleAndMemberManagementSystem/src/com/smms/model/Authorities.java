package com.smms.model;

import javax.persistence.*;

@Entity
@Table(name = "Authoritie")
public class Authorities implements java.io.Serializable {

	@Id
	@OneToOne
	@JoinColumn(name = "USERNAME", nullable = false)
	private Users username;
	@Column(name = "AUTHORITY", length = 50, nullable = false)
	private String authority;

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
	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
