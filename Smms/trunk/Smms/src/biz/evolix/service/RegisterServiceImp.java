package biz.evolix.service;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.model.dao.Role;

public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private Node1DAO  node1DAO;
	
	private static final Collection<Node1> uplines = new HashSet<Node1>();
	@Override
	public void save(Node1 m,Long id) {
		Users u=registerDAO.save(m,id,"99");		
		authoritiesDAO.authorization(u,Role.ROLE_MEMBER.name());
		if(getUplines().contains(m))getUplines().remove(m);
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

	@Override
	public Collection<Node1> listUpline() {
		if(getUplines().isEmpty()){
			getUplines().addAll(getUplines());
		}
		return getUplines();
	}

	public Collection<Node1> getUplines() {
		return uplines;
	}
	public Collection<Node1> uplines(){
		NodeDescription d  = null;
		try{
			d = registerDAO.getDescription();
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		Collection<Node1> c = new HashSet<Node1>();
		if( d!=null){
			long id = d.getNextId();
			Node1 n = null;
			while(id<d.getMaxNode()){
				n= node1DAO.getNode1(id);
				if(n == null){
					long p = Generate.getParentId(id);
					n= node1DAO.getNode1(p);
					if(!c.contains(n))c.add(n);
				}
			}
		}	
		return c;
	}
	private static Logger log = Logger.getLogger(RegisterServiceImp.class);
}