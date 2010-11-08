package biz.evolix.model.dao;



import org.springframework.dao.DataAccessException;

import biz.evolix.model.Node1;

public interface Node1DAO {
	public Node1 getNode1(Long node)throws DataAccessException;
	public Node1 getNode1FromUserId(String u)throws DataAccessException;
	public boolean update(Node1 node)throws DataAccessException;
	public boolean updateOther(Node1 node)throws DataAccessException;	
}
