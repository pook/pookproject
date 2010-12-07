package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.Users;

public class UsersDAOImp extends JpaDaoSupport implements UsersDAO {
	
	private static Logger log = Logger.getLogger(UsersDAOImp.class);
	public Users userDetail(String id){
		try{
			Users u =getJpaTemplate().find(Users.class, id);
			u.getAuthorities();
			return u;
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
