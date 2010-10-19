package com.smms.service;

import java.util.Date;

public class Item {
	private int id;
	private Date date;
	private int productCode;
	private String productName;
	private String productDetail;
	private Double price;
	private int unit;
	private int totalPV;
	public Item(int id, Date date, int productCode, String productName,
			String productDetail, Double price, int unit, int totalPV) {
		super();
		this.id = id;
		this.date = date;
		this.productCode = productCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.unit = unit;
		this.totalPV = totalPV;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getTotalPV() {
		return totalPV;
	}
	public void setTotalPV(int totalPV) {
		this.totalPV = totalPV;
	}
	
	
}
