package biz.evolix.service.sub;

import java.util.List;

import biz.evolix.model.bean.UserBean;
import biz.evolix.model.bean.UserRoleBean;

public interface RoleService {
	public Integer sizeOfRevCard();
	public List<UserBean> userNotRevCard(int start,int max);
	public void updateCard(String userIds);
	public void resetPasswd(String userIds);
	public Integer sizeMember();
	public List<UserRoleBean> userRole(int start,int max);
	public void updateRole(UserRoleBean userrole);
	public List<UserRoleBean> search(String smileId);
	public List<UserRoleBean> searchByName(String name);
}
