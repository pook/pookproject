package com.smms.model;



import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Table(name="ACCOUNT")
public class Account implements java.io.Serializable {
	   
	@Id
	@GeneratedValue(generator="NODE_SEQ")
	@SequenceGenerator(name="NODE_SEQ",sequenceName="INC_NODE",allocationSize=5)
	@Column(name = "ACC_ID")
	private Long accID;
	@OneToOne
	@JoinColumn(name="USERNAME", nullable = false)
	private Users username;
	@OneToOne
	@JoinColumn(name="LEFT1")
	private Account left;
	@OneToOne
	@JoinColumn(name="RIGHT1")
	private Account right;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	 
	public Users getUsername() {
		return this.username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}   
	public Account getLeft() {
		return this.left;
	}

	public void setLeft(Account left) {
		this.left = left;
	}   
	public Account getRight() {
		return this.right;
	}

	public void setRight(Account right) {
		this.right = right;
	}

	public void setAccID(Long accID) {
		this.accID = accID;
	}

	public Long getAccID() {
		return accID;
	}
   
}
