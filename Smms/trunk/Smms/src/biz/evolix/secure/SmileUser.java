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
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.LoadUser;

@Repository
@Transactional
public class SmileUser extends JpaDaoSupport implements UserDetails {

	private static Logger log = Logger.getLogger(SmileUser.class);
	private static final long serialVersionUID = 2680596480619638118L;
	private EntityManager em = Persistence.createEntityManagerFactory(
			ConstType.PERSISTENCE_UNIT).createEntityManager();
	private String smileid;
	private String name;
	private String displayName;
	private String inviter;
	private String passwd;
	private String brance;
	private String treeId;
	private Long pos;
	private Long userid;

	public SmileUser(String smileid) {
		super();
		this.smileid = smileid;
	}
	

	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<Authorities> auths = (Collection<Authorities>) getJpaTemplate()
				.findByNamedQuery("findAuthorities", this.userid);
		Collection<GrantedAuthority> gat = new HashSet<GrantedAuthority>();
		for (Authorities a : auths)
			gat.add(new GrantedAuthorityImp(a.getAuthority()));
		return gat;
	}

	public SmileUsersDetails loadUser() {
		return getUser1();
	}

	@Transactional(readOnly = true)
	private SmileUsersDetails getUser1() {
		try {			
			setEntityManager(em);			
			Users u = getJpaTemplate().execute(
					new LoadUser<Users>(getSmileid(), "loaduser"));
			this.passwd = u.getPassword();
			this.userid = u.getUserId();
			this.pos = u.getNode1().getPos();
			this.setTreeId(u.getNode1().getTreeId());
			setInviter(u.getNode1().getInviter());
			setDisplayName(u.getNode1().getDisplayName());
			setBrance(u.getSmile().getBrance());
			return null;
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
		return getSmileid();
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

	public String getSmileid() {
		return smileid;
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

	public void setBrance(String brance) {
		this.brance = brance;
	}

	public String getBrance() {
		return brance;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}

	public Long getPos() {
		return pos;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreeId() {
		return treeId;
	}

}
