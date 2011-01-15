package biz.evolix.model.bean;

public class UserDowlineBean extends User {

	public UserDowlineBean(Integer id, String smileId, String name,String address,String displayName,String status) {
		super(id, smileId, name);
		this.address = address;
		this.displayName = displayName;
		this.status = status;
	}
	
	private String status;
	private String address;
	private String displayName;
		
	
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

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
