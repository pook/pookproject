package biz.evolix.model.bean;

public class UserDowlineBean extends User {

	public UserDowlineBean(Integer id, String smileId, String name,String address,String displayName,String tel) {
		super(id, smileId, name);
		this.address = address;
		this.displayName = displayName;
		this.tel = tel;
	}
	private String tel;
	private String address;
	private String displayName;
		
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
}
