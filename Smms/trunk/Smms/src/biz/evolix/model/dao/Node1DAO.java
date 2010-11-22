package biz.evolix.model.dao;



import org.springframework.dao.DataAccessException;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;

public interface Node1DAO {
	public Node1 getNode1(Long node);
	public Node1 getNode1FromUser(Users u)throws DataAccessException;
	public Node1 getNode1FromUserId(String u)throws DataAccessException;
	public boolean update(Node1 node)throws DataAccessException;
	public boolean updateOther(Node1 node)throws DataAccessException;
	public boolean checkDisplayName(String displayName);
}
