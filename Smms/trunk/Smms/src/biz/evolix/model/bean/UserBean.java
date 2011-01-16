package biz.evolix.model.bean;

import java.util.Date;

public class UserBean extends User{	
	private String surename;	
	private String displayName;
	private String brance;
	private String branceCard;	
	private Date date;
	private Long userId;
	public UserBean(int id,long userId,String smileId, String name, String surename,
			String displayName, String brance, String branceCard,Date date) {
		super(id, smileId, displayName);
		this.surename = surename;this.userId = userId;
		this.displayName = displayName;
		this.brance = brance;
		this.branceCard = branceCard;this.date= date;
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getBrance() {
		return brance;
	}
	public void setBrance(String brance) {
		this.brance = brance;
	}
	public String getBranceCard() {
		return branceCard;
	}
	public void setBranceCard(String branceCard) {
		this.branceCard = branceCard;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserId() {
		return userId;
	}	
}
