package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
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
			n = node1DAO.findFromSmileId(o.getUser().getNode1().getSmileId());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (n != null) {
			int sv = o.getTotalSv();
			n.incSv(sv);
			node1DAO.update(n);
			NodePK id = new NodePK(n.getTreeId(),Generate.parent( n.getPos()));
			for(int i=0;i<16&&id.getPos()>0;i++)
				id = up(id.getPos(),id.getTreeId());						
		}
	}

	private NodePK up(long c,String treeId) {
		Node1 nl = null, nr = null, nc = null;
		if (c > 0 ){
			nc = node1DAO.find(new NodePK(treeId,c));
			nl = node1DAO.find(new NodePK(treeId,Generate.left(c))); 
			nr = node1DAO.find(new NodePK(treeId,Generate.right(c)));
			int com = 0;
			if (nl != null)
				com += nl.getCommissions();
			if (nr != null)
				com += nr.getCommissions();
			nc.setCommissions(com);
			node1DAO.update(nc);
			return new NodePK(treeId,Generate.parent(c));
		}
		return null;
	}
	
	@Override
	public void updateDec(Order o){
	/*	Node1 n = null;
		try {
			n = node1DAO.findFromSmileId(o.getUser().getSmile().getSmileId());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (n != null) {
			int sv = o.getTotalSv();
			n.decSv(sv);
			node1DAO.update(n);
			long c =Generate.parent( n.getPos());
			for(int i=0;i<15&&c>0;i++)
				c = up(c);						
		}
		*/
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}
}
