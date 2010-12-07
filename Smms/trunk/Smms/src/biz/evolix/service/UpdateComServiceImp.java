package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.Order;
import biz.evolix.model.dao.Node1DAO;

public class UpdateComServiceImp implements UpdateComService {

	private static Logger log = Logger.getLogger(UpdateComServiceImp.class);
	@Autowired
	private Node1DAO node1DAO;

	@Override
	public void update(Order o) {
		Node1 n = null;
		try {
			n = node1DAO.getNode1FromUser(o.getUser());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		if (n != null) {
			int sv = o.getTotalSv();			
			n.incSv(sv);
			node1DAO.update(n);
			up(Generate.getParentId((n.getNodeId())));
		}
	}

	private void up(long c) {		
		Node1 nl = null,nr=null,nc=null;		
		if (c > 0) {
			nc = node(c);
			nl = node(Generate.getLeftChildId(c));
			nr = node(Generate.getRightChildId(c));
			int com = 0;
			if (nl != null)
				com += nl.getCommissions();
			if (nr != null)
				com += nr.getCommissions();
			nc.setCommissions(com);
			node1DAO.updateOther(nc);
			up(Generate.getParentId((nc.getNodeId())));
		}
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	public Node1 node(long c) {
		try {
			return node1DAO.getNode1(c);
		} catch (Exception e) {
			//log.error(e.getMessage());
			return null;
		}
	}

}
