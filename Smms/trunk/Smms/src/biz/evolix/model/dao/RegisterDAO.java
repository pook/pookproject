package biz.evolix.model.dao;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;

public interface RegisterDAO {
	public Users save(Users u,Long id,String pid,long n);		
	public NodeDescription getDescription(long id);
	public boolean checkLevel(long n);
	public void update(NodeDescription d,long id);
}
