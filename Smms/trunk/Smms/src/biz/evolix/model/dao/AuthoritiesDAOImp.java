package biz.evolix.model.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.CheckPasswdCB;

@Repository
@Transactional
public class AuthoritiesDAOImp extends JpaDaoSupport implements AuthoritiesDAO {

	@Override
	@Transactional
	public boolean authorization(Users user, String role) {
		Authorities auth = new Authorities();
		auth.setAuthority(role);
		auth.setUser(user);
		user.getAuthorities().add(auth);
		try {
			getJpaTemplate().merge(user);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Collection<Authorities> findAuth(final String id) {
		return (Collection<Authorities>) getJpaTemplate().findByNamedQuery("findAuthorities", id);
	}
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	public Users findUser(String userId)throws NullPointerException,DataAccessException {		
		return getJpaTemplate().find(Users.class,userId);
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {		
		return (List<Users>)getJpaTemplate().find("select U from Users u");
	}*/

	@Override
	@Transactional(readOnly=false)
	public boolean chgpw(String uid, String newpw) {
		try{
			Users u = getJpaTemplate().find(Users.class, uid);
			u.setPassword(newpw);
			getJpaTemplate().merge(u);
			return true;
		}catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		
	}
	@Transactional(readOnly=true)
	@Override
	public boolean ckpasswd(String uid, String pw) {
		return getJpaTemplate().execute(new CheckPasswdCB<Users>(uid, pw))!=null;
	}
	private static Logger log = Logger.getLogger(AuthoritiesDAOImp.class);

}
