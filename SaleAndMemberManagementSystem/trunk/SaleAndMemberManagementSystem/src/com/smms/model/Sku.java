package com.smms.model;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sku
 *
 */
@Entity
@Table(name="SKU")
public class Sku implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="S_ID")
	private Long sid;
	@Column(name="NAME",length = 50, nullable = false)
	private String name;
	@Column(name="PRICE",precision=2)
	private Double price;
	@Column(name="PV")
	private Integer pv;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="IMAGE")
	private String image;
	private static final long serialVersionUID = 1L;

	public Sku() {
		super();
	}   
	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}   
	public Integer getPv() {
		return this.pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
   
}
