package biz.evolix.model.bean;

public class UserBean extends User{	
	private String surename;	
	private String displayName;
	private String brance;
	private String branceCard;	
	
	public UserBean(int id,String smileId, String name, String surename,
			String displayName, String brance, String branceCard) {
		super(id, smileId, displayName);
		this.surename = surename;
		this.displayName = displayName;
		this.brance = brance;
		this.branceCard = branceCard;
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
}
