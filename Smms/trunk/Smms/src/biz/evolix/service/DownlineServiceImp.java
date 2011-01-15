package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.Users;
import biz.evolix.model.bean.UserDowlineBean;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class DownlineServiceImp implements DownlineService {

	@Autowired
	private UsersDAO usersDAO;

	@Override
	public int size() {
		long i = usersDAO.size(getUsers().getDisplayName(),"userdownlinesize");
		return (int) i;
	}

	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	private static Logger log = Logger.getLogger(DownlineServiceImp.class);

	@Override
	public List<UserDowlineBean> downline(int start, int max) {
		List<Users> users = usersDAO.find(start, max, getUsers()
				.getDisplayName(), "loaddownline");
		return downline(users);
	}

	private List<UserDowlineBean> downline(List<Users> users) {
		List<UserDowlineBean> downs = new ArrayList<UserDowlineBean>();
		if (users == null)
			return downs;
		int i = 0;
		for (Users user : users) {
			downs.add(new UserDowlineBean(i++,user.getNode1().getSmileId(), user.getDetail().getName(), user.getDetail().getAddress(),
					user.getNode1().getDisplayName(),status(user.getNode1().getStatus())));
		}
		return downs;
	}
	private static String status(char status){
		switch (status) {
		case 'A':
			return "ACTIVE";
		default:
			return "INACTIVE";
		}
	}
}
