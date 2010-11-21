package biz.evolix.model;

import biz.evolix.gen.Generate;
import biz.evolix.model.Users;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
@Table(name = "NODE1")
public class Node1 implements java.io.Serializable,Comparable<Node1>{

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nId ;
	@Column(name = "DISPLAYNAME", nullable = false, unique = true)
	private String displayName ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Users user ;

	@Column(name = "SMILE_VALUE", updatable = true)
	private Integer sv = 0;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;
	//@Column(name="STATUS")
	//private char status;
	public Node1() {
		super();
	}

	public Long getNId() {
		return this.nId;
	}

	public void setNId(Long nId) {
		this.nId = nId;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getSv() {
		return this.sv;
	}

	public void setSv(Integer sv) {
		
		this.sv = getSv()+sv;
	}

	public Integer getCommissions() {
		return this.commissions +(int) Generate.xCommission(getSv());
	}

	public void setCommissions(Integer commissions) {
		this.commissions = commissions;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	// @Basic(fetch=FetchType.EAGER)
	public Users getUser() {
		return user;
	}

	public String toString() {
		return getNId() + " " + getDisplayName() + "  " + getCommissions();
	}

	public void setStatus(char status) {
	//	this.status = status;
	}

	public char getStatus() {
		return ' ';//status;
	}

	@Override
	public int compareTo(Node1 o) { 
		return ((int)(getNId()-o.nId));
	}
	
	public boolean equals(Object other){
		if(other instanceof Node1 ){
			Node1 n  = (Node1)other;
			return this.nId == n.nId;
		}
		
		return false;
	}
}
