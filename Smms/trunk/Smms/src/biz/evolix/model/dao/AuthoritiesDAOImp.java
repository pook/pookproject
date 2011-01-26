package biz.evolix.model.dao;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.FindByCondition2;
import biz.evolix.model.dao.callback.UpdateCon1;

@Repository
@Transactional
public class AuthoritiesDAOImp extends JpaDaoSupport implements AuthoritiesDAO {

	@Override
	@Transactional
	public void insert(Authorities auth) {	
		try {
			getJpaTemplate().persist(auth);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<Authorities> findAuth(final String id) {
		return (Collection<Authorities>) getJpaTemplate().findByNamedQuery("findAuthorities", id);
	}
	
	/*
	 * @Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	public SmileUsersDetails findUser(String userId)throws NullPointerException,DataAccessException {		
		return getJpaTemplate().find(SmileUsersDetails.class,userId);
	}
	*/
    @Override
    @Transactional(readOnly=false)
    public boolean chgpw(long uid, String newpw) {
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
            return getJpaTemplate().execute(new FindByCondition2<Users>(uid, pw,"ckpasswd"))!=null;
    }


	private static Logger log = Logger.getLogger(AuthoritiesDAOImp.class);


	@Override
	@Transactional
	public void remove(long userId,String role) {
		try{
			Authorities auth =getJpaTemplate().execute(new FindByCondition2<Authorities>(userId, role,"findAuthorities2"));
			getJpaTemplate().remove(auth);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}		
	}

	@Override
	@Transactional
	public void remove1(Authorities auth) {
		try{
			Authorities a=getJpaTemplate().find(Authorities.class,auth.getAuthId());
			getJpaTemplate().remove(a);
		}catch (Exception e) {
			log.error(e.getMessage());		}
	}

	@Override
	public void merg(Authorities auth) {
		try{
			getJpaTemplate().merge(auth);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}

	@Override
	public Authorities findByName(String name,Users user) {
		Authorities auth = null;
		try{
			auth = getJpaTemplate().execute(new FindByCondition2<Authorities>(name,user,"findAuthoritiesByName"));
		}catch (Exception e) {	
			
		}
		return auth;
	}

}
