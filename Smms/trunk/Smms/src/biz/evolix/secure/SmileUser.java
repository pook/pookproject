package biz.evolix.secure;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.RegisterDAO;

public class SmileUser implements UserDetails {

	private static final long serialVersionUID = 2680596480619638118L;
	
	private Users user;
	private Node1 node;
	
	@Autowired
	private Node1DAO  node1DAO;
	@Autowired
	private RegisterDAO registerDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<Authorities>auths= authoritiesDAO.findAuth(getUsername());
		Collection<GrantedAuthority>gas = new HashSet<GrantedAuthority>();
		for(Authorities a:auths){
			gas.add(new GrantedAuthorityImp(a.getAuthority()));
		}			
		return gas;
	}
	public Users loadUser(String userid){
		return authoritiesDAO.findUser(userid);
	}

	@Override
	public String getPassword() {
		return getUser().getPassword();
	}

	@Override
	public String getUsername() {
		return getUser().getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getUser().getEnaebled()==1;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Users getUser() {
		return user;
	}

	public void setNode(Node1 node) {
		this.node = node;
	}

	public Node1 getNode() {
		return node;
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

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}	
}
