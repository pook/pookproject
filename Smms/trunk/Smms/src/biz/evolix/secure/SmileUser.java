package biz.evolix.secure;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evlix.customconst.ConstType;
import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;

@Repository
@Transactional
public class SmileUser extends JpaDaoSupport implements UserDetails {

	private static final long serialVersionUID = 2680596480619638118L;
	private EntityManager em = Persistence.createEntityManagerFactory(ConstType.PERSISTENCE_UNIT)
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
		Collection<Authorities> auths = (Collection<Authorities>) getJpaTemplate()
				.find("select A from Authorities A where A.user.userId =?1",
						getUserid());		
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		for (Authorities a : auths)
			gas.add(new GrantedAuthorityImp(a.getAuthority()));
		return gas;
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Users loadUser() {
		try {
			setEntityManager(em);
			Users u = (Users) getJpaTemplate().find(Users.class, getUserid());
			setNode(u.getNode1());
			
			return u;
		} catch (Exception e) {
			throw new UsernameNotFoundException(e + ": username");
		}
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
