package biz.evolix.model.dao;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;

public interface RegisterDAO {
	public Users save(Users u,Long id,String pid);
	public Long getID(Long id);	
	public NodeDescription getDescription();
}
