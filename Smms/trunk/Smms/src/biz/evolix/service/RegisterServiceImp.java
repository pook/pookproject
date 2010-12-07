package biz.evolix.service;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evlix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.model.dao.Role;
import biz.evolix.secure.SmileUser;

public class RegisterServiceImp implements RegisterService {

	private static final int MAX = 128;
	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	@Autowired
	private Node1DAO node1DAO;

	@Override
	public void save(Users u, Long id, String pv) {
		id = (id == ConstType.AUTO) ? ConstType.AUTO : Generate
				.getLeftChildId(id);
		u = insert(u, id, pv);
		authoritiesDAO.authorization(u, Role.ROLE_MEMBER.name());
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	private Users insert(Users u, Long id, String pv) {
		synchronized (this) {
			u = registerDAO.save(u, id, pv);
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

	@Override
	public Collection<Node1> listUpline() {
		return getUplines();
	}

	public Collection<Node1> getUplines() {
		return uplines();
	}

	public Collection<Node1> uplines() {
		NodeDescription d = null;
		try {
			d = registerDAO.getDescription();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		Collection<Node1> c = new HashSet<Node1>();
		if (d != null) {
			long id = d.getNextId();
			Node1 n = null;
			int count = 0;
			while (id++ < d.getUpper() && ++count < MAX) {
				try {
					n = node1DAO.getNode1(id);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
				if (n == null) {
					long p = Generate.getParentId(id);
					Node1 n1 = null;
					try {
						n1 = node1DAO.getNode1(p);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
					add(c, n1);
				}
			}
		}
		return c;
	}

	private void add(Collection<Node1> c, Node1 n1) {
		if (!c.contains(n1))
			c.add(n1);
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
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}
}