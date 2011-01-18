package biz.evolix.service.sub;

import java.util.List;


import biz.evolix.model.bean.UserStaff;

public interface StaffMemberService {
	public Integer size();	
	public List<UserStaff> userRole(int start,int max);
	public void updateMaxRegister(int idx,int max);
	public List<UserStaff> search(String smileId);
}
