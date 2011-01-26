package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.Order;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.utils.Utils;

public class UpdateComServiceImp implements UpdateComService {

	private static final int LOOP = 16;
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
			NodePK id = parent(n.getTreeId(), n.getPos());
			update(id);
		}
	}
	private void update(NodePK id){
		for (int i = 0; i < LOOP && id.getPos() > 0; i++)
			id = up(id.getPos(), id.getTreeId());
	}

	private NodePK up(long c, String treeId) {
		NodePK id = null;
		if (c > 0) {
			Node1 nc = node1DAO.find(new NodePK(treeId, c));
			Node1 nl = (Utils.inRange(c)) ? node1DAO.find(new NodePK(NodePK.hashNode1(treeId+c),
					new Long(2))) : node1DAO.find(new NodePK(treeId, Generate
					.left(c)));
			Node1 nr = (Utils.inRange(c))? node1DAO.find(new NodePK(NodePK.hashNode1(treeId+c),
					new Long(3))) : node1DAO.find(new NodePK(treeId, Generate
					.right(c)));
			int com = 0, totalSv = 0;
			if (nl != null) {
				com += nl.getCommissions();
				totalSv += (nl.getSv() + nl.getTotalSv());
			}
			if (nr != null) {
				com += nr.getCommissions();
				totalSv += (nr.getSv() + nr.getTotalSv());
			}
			nc.setCommissions(com);
			nc.setTotalSv(totalSv);
			node1DAO.update(nc);
			id = parent(treeId, c);
		}
		return id;
	}

	private NodePK parent(String treeId, long c) {
		NodePK id = null;
		long p = Generate.parent(c);
		if (p == ConstType.ONE) {			
			Node1 nt = node1DAO.findByHashCode(treeId);
			id = (nt == null) ? new NodePK(treeId, p) : new NodePK(
					nt.getTreeId(), nt.getPos());
		} else
			id = new NodePK(treeId, p);
		return id;
	}

	@Override
	public void dec(Order o) {
		Node1 n = null;
		try {
			n = node1DAO.findFromSmileId(o.getUser().getNode1().getSmileId());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		if (n != null) {
			int sv = o.getTotalSv();
			n.decSv(sv);
			node1DAO.update(n);
			NodePK id = parent(n.getTreeId(), n.getPos());
			update(id);
		}
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}
}
