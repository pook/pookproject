package biz.evolix.model.bean;

public class NodeBean {
	private String smileId;
	private String treeId;
	private String pos;
	private String inviter;
	private String displayName;
	private Character status;
	
	public NodeBean(String smileId,String treeId, String pos, String inviter,
			String displayName,char status) {
		super();
		this.smileId = smileId;
		this.treeId = treeId;
		this.pos = pos;
		this.inviter = inviter;
		this.displayName = displayName;
		this.status = status;
	}
	public NodeBean(){
		this("","","-2","","",' ');
	}
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getInviter() {
		return inviter;
	}
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getSmileId() {
		return smileId;
	}
	public void setSmileId(String smileId) {
		this.smileId = smileId;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public Character getStatus() {
		return status;
	}
	
}
