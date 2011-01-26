package biz.evolix.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.bean.Temp;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.utils.Utils;

public class FindPlaceServiceImp implements FindPlaceService {

	@Autowired
	private Node1DAO node1DAO;
	@Autowired
	private NodeDeptDAO nodeDeptDAO;

	@Override
	public NodePK manual(long chose, String treeId) {
		if (chose < ConstType.ONE)
			return null;
		NodePK id = new NodePK(treeId, chose);
		return (node1DAO.find2(id) == null)?id:null;			
	}

	@Override
	public NodePK auto(NodeDescription dHead, String treeId, boolean auto,
			Temp<Integer> level, boolean test) {
		NodePK id = null;
		List<String> hashs = null;		
		if (dHead.getNextId() < dHead.getPos()) {
			hashs = Utils.hashCodes(treeId, dHead.getBaseLevel(),
					dHead.getPos());
		} else {
			hashs = new ArrayList<String>();
			hashs.add(treeId);
		}
		Iterator<String> itr = hashs.iterator();		
		id = auto1(dHead, auto, level, test, itr);
		return id;

	}

	private NodePK auto1(NodeDescription dHead, boolean auto,
			Temp<Integer> level, boolean test, Iterator<String> itr) {
		boolean found = false;
		String treeId = itr.next();
		long low = dHead.getLower();
		long next = dHead.getNextId(), upper = dHead.getUpper();
		NodePK id2 = new NodePK(treeId, next);
		while (!found) {
			Node1 node = node1DAO.find2(id2);
			if (node == null)
				found = true;
			if (next >= upper) {
				level.setTemp(dHead.getHigh());
				if (itr.hasNext()) {
					dHead.setCount(dHead.getCount() + 1);
					dHead.setNextId(low);
					treeId = itr.next();					
				} else if (Utils.inRange(next)) {
					Utils.resetNodeDept(dHead, true);					
				} else {
					Utils.updateNodeDept(upper + 1, dHead, true);
					upper = dHead.getUpper();					
				}
			} else {
				dHead.setCount(dHead.getCount() + 1);
				dHead.setNextId(dHead.getNextId() + 1);
			}
			if (!found) {
				id2 = new NodePK(treeId, (next = dHead.getNextId()));
				level.setTemp(dHead.getHigh());
			}
		}
		nodeDeptDAO.update(dHead);
		return id2;
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	public void setNodeDeptDAO(NodeDeptDAO nodeDeptDAO) {
		this.nodeDeptDAO = nodeDeptDAO;
	}

	public NodeDeptDAO getNodeDeptDAO() {
		return nodeDeptDAO;
	}

	private static Logger log = Logger.getLogger(FindPlaceServiceImp.class);
}
