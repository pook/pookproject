package biz.evolix.model.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;

@Repository
@Transactional
public class AuthoritiesDAOImp extends JpaDaoSupport implements AuthoritiesDAO {

	@Override
	@Transactional
	public boolean authorization(final Users user, String role) {
		List<Authorities> a = (List<Authorities>)findAuth(user.getUserId());
		for (Authorities auth : a) {
			if (auth.getAuthority().equals(role))
				return false;
		}
		Authorities auth = new Authorities();	
		auth.setAuthority(role);
		auth.setUser(user);	
		try {
			getJpaTemplate().persist(auth);
		} catch (Exception e) {
			System.err.println(e);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {		
		return (List<Users>)getJpaTemplate().find("select U from Users u");
	}

}
