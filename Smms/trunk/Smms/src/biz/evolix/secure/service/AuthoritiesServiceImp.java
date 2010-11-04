package biz.evolix.secure.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Node1DAO;

public class AuthoritiesServiceImp implements AuthoritiesService {

	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private Node1DAO node1DAO;
	
	@Override
	public Users findUsers(String userid) {
		 System.out.println("vvvvv");
			return authoritiesDAO.findUser(userid);
	}

	@Override
	public Node1 fimdNode1(String userid)throws NullPointerException,DataAccessException{		
		return node1DAO.getNode1FromUserId(userid);
	}

	@Override
	public Collection<Authorities> getAuthorities(String userid) {		
		return authoritiesDAO.findAuth(userid);
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

}
