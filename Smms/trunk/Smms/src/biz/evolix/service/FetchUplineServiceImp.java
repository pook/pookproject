package biz.evolix.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.secure.SmileUser;

public class FetchUplineServiceImp implements FetchUplineService {

	private static final int MAX = 128;
	@Autowired
	private Node1DAO node1DAO;

	@Autowired
	private NodeDeptDAO nodeDeptDAO;

	@Override
	public Map<String, String> uplines() {
		NodeDescription d = null;
		SmileUser head = getUsers();
		if (head == null)
			return new HashMap<String, String>();
		NodePK id = new NodePK(head.getTreeId(), head.getPos());
		d = nodeDeptDAO.id(id);
		Map<String, String> map = new HashMap<String, String>();
		uplines2(d, map, id);
		return map;
	}

	private void uplines2(NodeDescription d, Map<String, String> map, NodePK id) {
		if (d != null) {
			id.setPos(d.getNextId());
			int count = 0;
			boolean left = false;
			while (count < MAX) {
				Node1 node = node1DAO.find(id);
				count++;
				if (node == null) {
					left = id.isLeft();
					node = node1DAO.find(id);
					Node1 nodeParent = node1DAO.find(new NodePK(
							ConstType.HASHCODE_NODE0, id.getParent()));
					if (id.getPos() < d.getUpper()) {
						add(map, nodeParent, id, left);
						id.next();
						continue;
					} else if (id.getPos() == d.getUpper()) {
						add(map, nodeParent, id, left);						
						break;
					}

				} else {
					if (id.getPos() == d.getUpper()) {
						if (map.isEmpty()) {
							d.setPos(node.getPos() + 1);
							nodeDeptDAO.updateNodeDept(d.getNextId(),d);
							id.setPos(d.getNextId());
						} else
							break;
					}
					id.next();
				}
			}
		}
	}

	private void add(Map<String, String> map, Node1 n1, NodePK id, boolean left) {
		if (left) {
			map.put(id.getPos().toString(), n1.getDisplayName() + " ช้าย");
		} else {
			map.put(id.getPos().toString(), n1.getDisplayName() + " ขวา");
		}
	}

	private static Logger log = Logger.getLogger(FetchUplineServiceImp.class);

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

	public void setNodeDeptDAO(NodeDeptDAO nodeDeptDAO) {
		this.nodeDeptDAO = nodeDeptDAO;
	}

	public NodeDeptDAO getNodeDeptDAO() {
		return nodeDeptDAO;
	}
}
