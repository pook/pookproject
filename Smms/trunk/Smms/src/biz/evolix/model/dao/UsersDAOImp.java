package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.FindByCondition1;
@Repository
@Transactional(isolation=Isolation.DEFAULT)
public class UsersDAOImp extends JpaDaoSupport implements UsersDAO {
	
	private static Logger log = Logger.getLogger(UsersDAOImp.class);
	public Users find(Long id){
		Users u = null;
		try{
			u=getJpaTemplate().find(Users.class, id);			
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return u;
	}
	@Override
	@Transactional
	public void persist(Users user) {
		try{
			getJpaTemplate().persist(user);			
		}catch (Exception e) {
			log.error(e.getMessage(), e);			
		}		
	}
	@Override
	@Transactional
	public void update(Users user) {
		try{
			getJpaTemplate().merge(user);
		}catch (Exception e) {
			log.error(e.getMessage());
		}		
	}
	@Override
	@Transactional(readOnly=true)
	public Users findBySmileUser(String smileId) {
		Users user = null;
		try{
			user = getJpaTemplate().execute(new FindByCondition1<Users>(smileId, "loaduser"));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return user;
	}
}
