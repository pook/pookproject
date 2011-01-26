package biz.evolix.service.sub;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Users;
import biz.evolix.model.bean.UserStaff;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.StaffDAO;
import biz.evolix.model.dao.UsersDAO;

public class StaffMemberServiceImp implements StaffMemberService {

	private static Logger log = Logger.getLogger(StaffMemberServiceImp.class);
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private StaffDAO staffDAO;

	private List<Users> users;
	List<UserStaff> roles;
	private int page = 0;
	@Override
	public Integer size() {
		long l = usersDAO.size();
		return (int) l;
	}
	
	@Override
	public List<UserStaff> userRole(int start, int max,int page) {
		this.page = page;
		users = usersDAO.find(start, max);
		return find(users);
	}

	private List<UserStaff> find(List<Users> users) {
		roles = new ArrayList<UserStaff>();
		for (int i = 0; i < users.size(); i++) {
			roles.add(new UserStaff(i, users.get(i).getUserId(), users.get(i)
					.getNode1().getSmileId(), users.get(i).getDetail()
					.getName(),users.get(i).getNode1().getDisplayName(), users.get(i).getMaxRegister(), users.get(i)
					.getDate(), ""));
		}
		return roles;
	}

	@Override
	public void updateMaxRegister(int idx, int max) {		
		Users user = users.get(idx);
		if (user != null) {			
			user.setMaxRegister(max);
			try {
				usersDAO.update(user);
				usersDAO.flush();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}

	}

	@Override
	public List<UserStaff> search(String smileId) {
		Users user = usersDAO.findBySmileUser(smileId);
		users = new ArrayList<Users>();
		users.add(user);
		return find(users);
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	@Override
	public int curpage() {		
		return this.page;
	}

	@Override
	public List<UserStaff> users() {		
		return this.roles;
	}

}
