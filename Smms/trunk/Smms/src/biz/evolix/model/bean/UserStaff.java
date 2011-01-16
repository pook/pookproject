package biz.evolix.model.bean;

import java.util.Date;

public class UserStaff extends User{

	public UserStaff(Integer id, String smileId, String name) {
		super(id, smileId, name);		
	}
	
	
	public UserStaff(Integer id,long userId, String smileId, String name, Date date,
			String brance) {
		super(id, smileId, name);
		this.date = date;
		this.brance = brance;
		this.userId = userId;
	}

	private Long userId;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBrance() {
		return brance;
	}
	public void setBrance(String brance) {
		this.brance = brance;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public Long getUserId() {
		return userId;
	}

	private Date date;
	private String brance;

}
