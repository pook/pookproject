package biz.evolix.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

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
		NodeDescription dept = null;
		SmileUser head = getUsers();
		if (head == null)
			return new HashMap<String, String>();
		NodePK id = new NodePK(head.getTreeId(), head.getPos());
		dept = nodeDeptDAO.find(id);
		Map<String, String> map = new HashMap<String, String>();
		uplines2(dept, map, id);
		return map;
	}

	private void uplines2(NodeDescription dept, Map<String, String> map,
			NodePK id) {
		if (dept != null) {
			id = new NodePK(id.getTreeId(), dept.getNextId());
			int count = 0;
			boolean left = false;
			while (count < MAX) {
				Node1 node = node1DAO.find2(id);
				count++;
				if (node == null) {
					left = id.isLeft();					
					Node1 nodeParent = node1DAO.find2(new NodePK(
							id.getTreeId(), id.getParent()));					
					long upper = dept.getUpper();
					if (id.getPos() < upper) {						
						add(map, nodeParent, id, left);
						id = new NodePK(id.getTreeId(), id.testNext());
						continue;
					} else if (id.getPos() == upper) {						
						add(map, nodeParent, id, left);
						if (map.isEmpty()) {
							nodeDeptDAO.updateNodeDept(dept.getUpper() + 1,
									dept, true);
						} else {
							break;
						}
					} else {
						add(map, nodeParent, id, left);
					}
				}
				id = new NodePK(id.getTreeId(), id.testNext());
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
