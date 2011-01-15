package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class FindMaxRegisterServiceImp implements FindMaxRegisterService {
	
	@Autowired
	private UsersDAO usersDAO;
	@Override
	public int max() {
		long id = getUsers().getUserid();
		return usersDAO.maxRegister(id);
	}
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}
	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	private static Logger log = Logger.getLogger(FindMaxRegisterServiceImp.class);

}
