package biz.evolix.model.bean;

public class UserDowlineBean extends User {

	public UserDowlineBean(Integer id, String smileId, String name,String address,String displayName,String status) {
		super(id, smileId, name,displayName);
		this.address = address;		
		this.status = status;
	}
	
	private String status;
	private String address;
		
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
