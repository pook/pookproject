package biz.evolix.model.bean;

public class UserDowlineBean extends User {

	public UserDowlineBean(Integer id, String smileId, String name,String displayName,String status) {
		super(id, smileId, name,displayName);
		//this.address = address;		
		this.status = status;
	}	
	private String status;
			
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;	
	}
}