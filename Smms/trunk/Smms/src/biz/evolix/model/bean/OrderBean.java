package biz.evolix.model.bean;

import java.util.Date;

public class OrderBean extends User{

	public OrderBean(Integer id, String smileId, String name,String displayName, Date date,
			Double totalPrice, Integer totalSv) {
		super(id, smileId, name,displayName);
		this.date = date;
		this.totalPrice = totalPrice;
		this.totalSv = totalSv;
	}

	private Date date;
	private Double totalPrice;
	private Integer totalSv;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getTotalSv() {
		return totalSv;
	}
	public void setTotalSv(Integer totalSv) {
		this.totalSv = totalSv;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	
}
