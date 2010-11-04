package biz.evolix.model.dao;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;

public interface RegisterDAO {
	public Users save(Node1 m,Long id);
	public Long getID(Long id);
}
