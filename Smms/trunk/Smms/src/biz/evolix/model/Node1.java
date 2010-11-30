package biz.evolix.model;

import biz.evolix.gen.Generate;
import biz.evolix.model.Users;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Transient;

@Entity
@NamedQueries({
		@NamedQuery(
				name="findDisplayName",
			    query="select N.nId from Node1 N where N.displayName=?1"
		),
		@NamedQuery(
				name="fidNode1ByUserId",
			    query="select N from Node1 N where N.user.userId=?1"
		),
		@NamedQuery(
				name="findNode1FromUser",
			    query="select N from Node1 N where N.user=?1"
		)	    
})

@Table(name = "NODE1")
public class Node1 implements java.io.Serializable{

	private static final long serialVersionUID = -7863722387808094242L;
	@Id
	@Column(name = "NODE_ID", nullable = false)
	private Long nId ;
	@Column(name = "DISPLAYNAME", nullable = false)
	private String displayName ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Users user ;

	@Column(name = "SMILE_VALUE", updatable = true)
	private Integer sv = 0;
	@Column(name = "COMMISSIONS")
	private Integer commissions = 0;
	@Column(name="STATUS")
	private Character status = 'V';
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
	@Transient
    public void decSv(Integer sv){
		setSv(getSv()-sv);
    }
	@Transient
    public void incSv(Integer sv){
    	setSv(getSv()+sv);
    }
	public void setSv(Integer sv) {		
		this.sv = sv;
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

	public void setStatus(Character status) {
		this.status = status;
	}

	public Character getStatus() {
		return status;
	}

/*
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
	*/
}
