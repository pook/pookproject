package biz.evolix.secure;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;

@Repository
@Transactional
public class SmileUser extends JpaDaoSupport implements UserDetails {

	private static final long serialVersionUID = 2680596480619638118L;
	private EntityManager em = Persistence.createEntityManagerFactory("SmmsPU")
			.createEntityManager();

	private final String userid;
	private Node1 node;
	
	
	
	public SmileUser(String userid) {
		super();
		this.userid = userid;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<Authorities> auths = (Collection<Authorities>) em
				.createQuery(
						"select A from Authorities A where A.user.userId =?1")
				.setParameter(1, getUserid()).getResultList();
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		for (Authorities a : auths)
			gas.add(new GrantedAuthorityImp("ROLE_MEMBER"));
		return gas;
	}

	@Transactional(readOnly = true)
	public Users loadUser() {
		try {
			setEntityManager(em);			
			Node1 node = getJpaTemplate().find(Node1.class, 1L);
			setNode(node);
			return node.getUser();
		} catch (Exception e) {
			System.err.println( e);
		}
		return null;
	}

	@Override
	public String getPassword() {
		return getNode().getUser().getPassword();
	}

	@Override
	public String getUsername() {
		return getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setNode(Node1 node) {
		this.node = node;
	}

	public Node1 getNode() {
		return node;
	}

	

}
