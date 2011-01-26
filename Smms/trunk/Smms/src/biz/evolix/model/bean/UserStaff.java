package biz.evolix.model.bean;

import java.util.Date;

public class UserStaff extends User implements Comparable{

	public UserStaff(Integer id, String smileId, String name,String displayName) {
		super(id, smileId, name,displayName);		
	}	
	
	public UserStaff(Integer id,long userId, String smileId, String name,String displayName ,Date date,
			String brance) {
		super(id, smileId, name,displayName);
		this.date = date;
		this.brance = brance;
		this.userId = userId;
	}
	

	public UserStaff(Integer id,Long userId, String smileId, String name,String displayName, Integer maxuser,
			Date date, String brance) {
		this(id,userId,smileId,name,displayName,date,brance);
		this.maxuser = maxuser;
	}

	private Integer maxuser = 0;
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

	public void setMaxuser(Integer maxuser) {
		this.maxuser = maxuser;
	}

	public Integer getMaxuser() {
		return maxuser;
	}

	private Date date;
	private String brance;

	@Override
	public int compareTo(Object o) {
		UserStaff st = (UserStaff)o;		
		return getSmileId().compareTo(st.getSmileId());
	}

}
