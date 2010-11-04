package biz.evolix.model.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
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
		System.out.println("Hello World");
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
		return (Collection<Authorities>) getJpaTemplate().find(
				"select A from Authorities A where A.user.userId =?1 ", id);
	}

	@Override
	public Users authentication(String username, String password) {
	
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Users findUser(String userId) {
		
		if(getJpaTemplate().getEntityManagerFactory()==null)System.out.println("bbbb");
		return getJpaTemplate().find(Users.class,userId);
	}

}
