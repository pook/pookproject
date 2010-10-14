package com.smms.model;

import com.smms.model.Account;
import com.smms.model.Sku;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Purchese
 *
 */
@Entity
@Table(name="PURCHESE")
public class Purchese implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="P_ID")
	private Long pid;
	@ManyToOne
	@JoinColumn(name="ACC_ID",nullable=false)
	private Account accID;
	@ManyToOne
	@JoinColumn(name="SK_ID",nullable=false)
	private Sku skid;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE")
	private Date date;
	@Column(name="TOTAL_PRICE")
	private Double totalPrice;
	@Column(name="UNIT_PV")
	private Integer unitPV;
	@Column(name="VOLUME")
	private Integer volume;
	@Column(name="VALUE")
	private Double value;
	@Column(name="TOTAL_PV")
	private Integer totalPV;
	private static final long serialVersionUID = 1L;

	public Purchese() {
		super();
	}   
	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}   
	public Account getAccID() {
		return this.accID;
	}

	public void setAccID(Account accID) {
		this.accID = accID;
	}   
	public Sku getSkid() {
		return this.skid;
	}

	public void setSkid(Sku skid) {
		this.skid = skid;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}   
	public Integer getUnitPV() {
		return this.unitPV;
	}

	public void setUnitPV(Integer unitPV) {
		this.unitPV = unitPV;
	}   
	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}   
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}   
	public Integer getTotalPV() {
		return this.totalPV;
	}

	public void setTotalPV(Integer totalPV) {
		this.totalPV = totalPV;
	}
   
}
