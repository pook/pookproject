package com.smms.service;

import java.util.Date;

public class Item {
	private int id;
	private String id2="X99999";
	private Date date;
	private String member;
	private int productCode;
	private String productName;
	private String productDetail;
	private Double price;
	private int unit;
	private int totalPV;
	private double commision;
	private double discount=11;
	private boolean a=false;
	private boolean b=false;
	private boolean c=true;
	private String bid="99999";
	public Item(int id, String id2, Date date, String member, int productCode,
			String productName, String productDetail, Double price, int unit,
			int totalPV, double commision, double discount, boolean a,
			boolean b, boolean c, String bid) {
		super();
		this.id = id;
		this.id2 = id2;
		this.date = date;
		this.member = member;
		this.productCode = productCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.unit = unit;
		this.totalPV = totalPV;
		this.commision = commision;
		this.discount = discount;
		this.a = a;
		this.b = b;
		this.c = c;
		this.bid = bid;
	}

	public Item(int id, Date date,String member, int productCode, String productName,
			String productDetail, Double price, int unit,double commision, int totalPV) {
		super();
		this.id = id;
		this.date = date;
		this.productCode = productCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.unit = unit;
		this.totalPV = totalPV;
		this.setCommision(commision);
		this.member=member;
		
	}
	
	public Item(int id, String id2, Date date, String member, int productCode,
			String productName, String productDetail, Double price, int unit,
			int totalPV, double commision, double discount, boolean a,
			boolean b, boolean c) {
		super();
		this.id = id;
		this.id2 = id2;
		this.date = date;
		this.member = member;
		this.productCode = productCode;
		this.productName = productName;
		this.productDetail = productDetail;
		this.price = price;
		this.unit = unit;
		this.totalPV = totalPV;
		this.commision = commision;
		this.discount = discount;
		this.a = a;
		this.b = b;
		this.c = c;
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
	public void setCommision(double commision) {
		this.commision = commision;
	}
	public double getCommision() {
		return commision;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public boolean isB() {
		return b;
	}
	public void setA(boolean a) {
		this.a = a;
	}
	public boolean isA() {
		return a;
	}
	public void setC(boolean c) {
		this.c = c;
	}
	public boolean isC() {
		return c;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getId2() {
		return id2;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getMember() {
		return member;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBid() {
		return bid;
	}
	
	
}
