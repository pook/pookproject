package biz.evolix.model.bean;

public class UserBean {

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getInvinter() {
		return invinter;
	}

	public void setInvinter(String invinter) {
		this.invinter = invinter;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeId() {
		return nodeId;
	}
	
	public UserBean(String userId, String nodeId, String displayName,
			String invinter, Character status) {
		super();
		this.userId = userId;
		this.nodeId = nodeId;
		this.displayName = displayName;
		this.invinter = invinter;
		this.status = status;
	}
	public UserBean(){
		this("","-2","","",' ');
	}

	private String userId;
	private String nodeId;
	private String displayName;
	private String invinter;
	private Character status;
}
