package biz.evolix.model.bean;

import java.util.Date;

public class UserRoleBean extends User{
	
	public UserRoleBean(Integer id, String smileId, String name,int maxuser,String tel) {
		super(id, smileId, name);
		this.maxuser = maxuser;	
		this.tel = tel;
	}
	
	public UserRoleBean(Integer id, String smileId, String name, Boolean admin,
			Boolean staff, Boolean member, Integer maxuser,String tel,Date date) {
		super(id, smileId, name);
		this.admin = admin;
		this.staff = staff;
		this.member = member;
		this.maxuser = maxuser;
		this.tel = tel;
		this.date = date;
	}

	private Boolean admin = false,staff = false,member = false;String tel;
	private Integer maxuser = 0;private Date date;
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean getStaff() {
		return staff;
	}
	public void setStaff(Boolean staff) {
		this.staff = staff;
	}
	public Boolean getMember() {
		return member;
	}
	public void setMember(Boolean member) {
		this.member = member;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getMaxuser() {
		return maxuser;
	}

	public void setMaxuser(Integer maxuser) {
		this.maxuser = maxuser;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	
}
