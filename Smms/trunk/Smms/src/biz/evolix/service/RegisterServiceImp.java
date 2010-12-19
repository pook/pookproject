package biz.evolix.service;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.model.dao.Role;
import biz.evolix.secure.SmileUser;

public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Override
	public Users save(Users u, Long id, String pv) {
		long n = (getUsers()==null)?0:getUsers().getNodeId();		
		id = (id == ConstType.AUTO) ? ConstType.AUTO : Generate
				.getLeftChildId(id);
		u = insert(u, id, pv,n);
		if (u != null)
			authoritiesDAO.authorization(u, Role.ROLE_MEMBER.name());
		return u;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	private Users insert(Users u, Long id, String pv,long n) {
		synchronized (this) {
			u = registerDAO.save(u, id, pv,n);
		}
		return u;
	}

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	

	private static Logger log = Logger.getLogger(RegisterServiceImp.class);

	@Override
	public void chgpw(String newpw) {
		try {
			authoritiesDAO.chgpw(getUsers().getUserid(),
					Generate.generateIdSHA(newpw));
			SecurityContextHolder.clearContext();
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public boolean checkPassword(String pw) {
		try {
			pw = Generate.generateIdSHA(pw);
			return authoritiesDAO.ckpasswd(getUsers().getUserid(), pw);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
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

	@Override
	public boolean checkLevel() {		
		return registerDAO.checkLevel(getUsers().getNodeId());
	}
}