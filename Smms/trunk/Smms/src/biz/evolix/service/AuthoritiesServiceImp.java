package biz.evolix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;
import biz.evolix.model.bean.AuthoritiesBean;
import biz.evolix.model.dao.AuthoritiesDAO;

public class AuthoritiesServiceImp implements AuthoritiesService {

	private List<AuthoritiesBean> auth ;
	
	@Autowired
	private  AuthoritiesDAO authoritiesDAO;
	
	@Override
	public List<Authorities> getAuthorities(Users user) {		
		return null;
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	public void setAuth(List<AuthoritiesBean> auth) {
		this.auth = auth;
	}

	public List<AuthoritiesBean> getAuth() {
		return auth;
	}

}
