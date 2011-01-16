package biz.evolix.service;
import java.util.List;

import biz.evolix.model.bean.UserStaff;
public interface StaffService {
	public int size();
	public List<UserStaff> staffs(int start,int max);
	public void editBrance(int idx,String brance);
}
