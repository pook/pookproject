package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Users;

public interface UsersDAO {
	public Users find(Long id);
	public Users findBySmileUser(String smileId);
	public void persist(Users user);
	public void update(Users user);
	public void updateQuery(Object arg0,String nameQuery);
	public Long sizeRevCard();
	public List<Users> userRecCard(int start,int max);
	public Long size();
	public List<Users> find(int start,int max);
	public void flush();	
	public long size(Object arg0,String nameQuery);
	public long size(String query);
	public List<Users>find(int start,int max,String query);
	public List<Users>find(int start,int max,Object arg0,String nameQuery);
	public int maxRegister(long user);
	public int findNextQuota(int next,Object id);
	public int findNumAccountQuota(Object id);
}
