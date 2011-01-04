package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.bean.Temp;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;

public class FindPlaceServiceImp implements FindPlaceService {

	@Autowired
	private Node1DAO node1DAO;
	@Autowired
	private NodeDeptDAO nodeDeptDAO;

	@Override
	public NodePK manual(long chose, String treeId) {
		if (chose == -2)
			return null;
		NodePK id = new NodePK(treeId, chose);
		if (node1DAO.find2(id) == null)
			return id;
		return null;
	}

	@Override
	public NodePK auto(NodeDescription dHead, boolean auto, Temp<Integer> level) {
		boolean found = false;
		long next = dHead.getNextId(), upper = dHead.getUpper();
		NodePK id2 = new NodePK(dHead.getTreeId(), next);
		while (!found) {
			Node1 node = node1DAO.find2(id2);
			if (node == null)
				found = true;
			if (id2.getPos() >= upper) {
				level.setTemp(dHead.getLevel());
				updateNodeDept(upper + 1, dHead, true);
				upper = dHead.getUpper();
			} else {
				dHead.setCount(dHead.getCount() + 1);
				dHead.setNextId(dHead.getNextId() + 1);
			}
			if (!found) {
				id2 = new NodePK(dHead.getTreeId(), (next = dHead.getNextId()));
				level.setTemp(dHead.getLevel());
			}
		}
		nodeDeptDAO.update(dHead);
		return id2;
	}

	public void updateNodeDept(long nxt, NodeDescription dept, boolean test) {
		if (test) {
			while (nxt > dept.getUpper()) {
				dept.setLevel(dept.getLevel() + 1);
				dept.setLower(Generate.left(dept.getLower()));
				dept.setUpper(Generate.right(dept.getUpper()));
				dept.setNextId(dept.getLower());
				dept.setCount(0L);
			}
		}
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
