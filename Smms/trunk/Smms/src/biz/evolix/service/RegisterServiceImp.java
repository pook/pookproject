package biz.evolix.service;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.model.dao.Role;

public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	@Override
	public void save(Node1 m,Long id) {
		Users u=registerDAO.save(m,id);		
		authoritiesDAO.authorization(u,Role.ROLE_MEMBER.name());
	}
	
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
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

}
