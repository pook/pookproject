package biz.evolix.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.RegisterDAO;
import biz.evolix.secure.SmileUser;

public class FetchUplineServiceImp implements FetchUplineService {

	private static final int MAX = 128;

	@Autowired
	private RegisterDAO registerDAO;
	@Autowired
	private Node1DAO node1DAO;

	@Override
	public Collection<Node1> uplines() {
		NodeDescription d = null;
		if (getUsers() == null)
			return new ArrayList<Node1>();
		try {
			d = registerDAO.getDescription(getUsers().getNodeId());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		long id = d.getNextId();
		Collection<Node1>coll = new ArrayList<Node1>();
		 id = uplines2(d,coll,id);
		while(coll.isEmpty()){
			id = uplines2(d,coll, id);
			registerDAO.update(d, id);
			System.out.println("id:"+id);
		}		
		return coll;
	}
	
	private long uplines2(NodeDescription d,Collection<Node1>c,long id){			
		if (d != null) {
			id = d.getNextId();
			int count = 0;						
			while ((id-1) < d.getUpper() && ++count < MAX) {
				Node1 n = null;
				try {
					n = node1DAO.getNode1(id);
				} catch (Exception e) {	}
				if (n == null) {
					long p = Generate.getParentId(id);
					Node1 np = null;
					try {
						np = node1DAO.getNode1(p);
					} catch (Exception e) {	}
					add(c, np);
				}
				id++;
			}
		}
		return id-1;		
	}

	private void add(Collection<Node1> c, Node1 n1) {
		if (!c.contains(n1))
			c.add(n1);
	}

	private static Logger log = Logger.getLogger(FetchUplineServiceImp.class);

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	public void setNode1DAO(Node1DAO node1dao) {
		node1DAO = node1dao;
	}

	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
