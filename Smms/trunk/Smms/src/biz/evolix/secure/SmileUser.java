package biz.evolix.secure;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Authorities;
import biz.evolix.model.Brance;
import biz.evolix.model.Users;

@Repository
@Transactional
public class SmileUser extends JpaDaoSupport implements UserDetails {

	private static Logger log = Logger.getLogger(SmileUser.class);
	private static final long serialVersionUID = 2680596480619638118L;
	private EntityManager em = Persistence.createEntityManagerFactory(
			ConstType.PERSISTENCE_UNIT).createEntityManager();
	private String userid;
	private String name;
	private String displayName;
	private String inviter;
	private String passwd;
	private String brance;
	private Long nodeId;

	public SmileUser(String userid) {
		super();
		this.userid = userid;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<Authorities> auths = (Collection<Authorities>) getJpaTemplate()
				.findByNamedQuery("findAuthorities", getUserid());
		Collection<GrantedAuthority> gat = new HashSet<GrantedAuthority>();
		for (Authorities a : auths)
			gat.add(new GrantedAuthorityImp(a.getAuthority()));
		return gat;
	}

	public Users loadUser() {
		return getUser1();
	}

	@Transactional(readOnly = true)
	private Users getUser1() {
		try {
			setEntityManager(em);
			Users u = (Users) getJpaTemplate().find(Users.class, getUserid());			
			this.passwd = u.getPassword();
			setNodeId(u.getNode1().getNodeId());
			setInviter(u.getNode1().getInviter());
			setDisplayName(u.getNode1().getDisplayName());			
			setBrance(u.getBrance());
			return u;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new UsernameNotFoundException(e + ": username");
		}
	}

	@Override
	public String getPassword() {
		return this.passwd;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getInviter() {
		return inviter;
	}

	public void setInviter(String inviter) {
		this.inviter = inviter;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getBrance() {
		return brance;
	}

}
