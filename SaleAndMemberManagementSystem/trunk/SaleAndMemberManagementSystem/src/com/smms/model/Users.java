package com.smms.model;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Users
 * 
 */
@Entity
@Table(name = "Users")
public class Users implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USERNAME", length = 50, nullable = false, unique = true)
	private String username;
	@Column(name = "PASSWORD", length = 50, nullable = false)
	private String password;
	@Column(name = "INVITER", length = 50, nullable = false)
	private String inviter;
	@Column(name = "ENABLED", nullable = false)
	private Byte enaebled;
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInviter() {
		return this.inviter;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
	}

	public void setEnaebled(Byte enaebled) {
		this.enaebled = enaebled;
	}

	public Byte getEnaebled() {
		return enaebled;
	}

}
