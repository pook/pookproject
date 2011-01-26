package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.Staff;
import biz.evolix.model.Users;

public interface StaffDAO {
	public Staff find(long userId);
	public Staff find2(long userId);
	public void persist(Staff staff);
	public void remove(Staff staff);
	public long size();
	public List<Users> findAllStaff(int start,int max);
	public void merg(Staff staff);
	public void update(Object arg0,Object arg1,String nameQuery);
}
