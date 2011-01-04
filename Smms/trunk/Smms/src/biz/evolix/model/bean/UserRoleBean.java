package biz.evolix.model.bean;

public class UserRoleBean extends User{
	
	public UserRoleBean(Integer id, String smileId, String name, Boolean allow,String tel) {
		super(id, smileId, name);
		this.allow = allow;
	}
	
	public UserRoleBean(Integer id, String smileId, String name, Boolean admin,
			Boolean staff, Boolean member, Boolean allow,String tel) {
		super(id, smileId, name);
		this.admin = admin;
		this.staff = staff;
		this.member = member;
		this.allow = allow;
		this.tel = tel;
	}

	private Boolean admin = false,staff = false,member = false,allow = false;String tel;
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
	public Boolean getAllow() {
		return allow;
	}
	public void setAllow(Boolean allow) {
		this.allow = allow;
	}		
}
