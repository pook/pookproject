package biz.evolix.service;

import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evlix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.Users;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.model.dao.Role;

public class RegisterServiceImp implements RegisterService {
	
	private static final int MAX = 128;
	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	@Autowired
	private Node1DAO  node1DAO;
	
	//private static final Collection<Node1> uplines = new HashSet<Node1>();
	@Override
	public void save(Node1 m,Long id) {
		id =(id==ConstType.AUTO)?ConstType.AUTO:Generate.getLeftChildId(id);
		Users u =insert(m,id);		
		authoritiesDAO.authorization(u,Role.ROLE_MEMBER.name());
	}
	
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
	
	private Users insert(Node1 m,Long id){
		Users u = null;
		synchronized (this) {
			u=registerDAO.save(m,id,"99");		
		//	if(getUplines().contains(m))getUplines().remove(m);
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
			int count = 0;
			while(id++<d.getUpper()&&++count<MAX){				
				try{
					n= node1DAO.getNode1(id);
				}catch (Exception e) {
					log.error(e.getMessage());				
				}				
				if(n == null){
					long p = Generate.getParentId(id);
					Node1 n1= null;					
					try{
						n1= node1DAO.getNode1(p);
					}catch (Exception e) {
						log.error(e.getMessage());			
					}				
					add(c,n1);
				}
			}
		}
		return c;
	}
	private void add(Collection<Node1> c,Node1 n1){		
		if(!c.contains(n1))c.add(n1);				
	}
	private static Logger log = Logger.getLogger(RegisterServiceImp.class);
}