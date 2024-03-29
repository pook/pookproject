package biz.evolix.model.bean;

public class User{
	private Integer id;
	private String smileId;
	private String name;
	private String displayName;
	
	
	public User() {
		super();
	}
	public User(Integer id, String smileId, String name,String displayName) {
		super();
		this.setId(id);
		this.smileId = smileId;
		this.name = name;
		this.displayName = displayName;
	}
	public String getSmileId() {
		return smileId;
	}
	public void setSmileId(String smileId) {
		this.smileId = smileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayName() {
		return displayName;
	}
	
}
