package biz.evolix.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.secure.SmileUser;

public class FetchUplineServiceImp implements FetchUplineService {

	private static final int MAX = 128;

	@Autowired
	private NodeDeptDAO nodeDeptDAO;
	@Autowired
	private Node1DAO node1DAO;

	@Override
	public Map<String, String> uplines() {
		NodeDescription dept = null;
		SmileUser head = getUsers();
		if (head == null)
			return new HashMap<String, String>();
		NodePK id = new NodePK(head.getTreeId(), head.getPos());
		dept = nodeDeptDAO.find(id);
		Map<String, String> map = new HashMap<String, String>();
		while (map.isEmpty()) {
			uplines2(dept, map, id);
			if (map.isEmpty())
				updateNodeDept(dept.getUpper() + 1, dept, true);
		}
		return map;
	}

	private void uplines2(NodeDescription dept, Map<String, String> map,
			NodePK id) {

		final long upper = dept.getUpper();
		int level = dept.getLevel();
		long lower = dept.getNextId();
		List<Long> nonspace = node1DAO.findNonSpace(lower, upper);
		boolean isLeft = true;		
		while (lower <= upper) {
			if (!nonspace.contains(lower)) {
				isLeft = Generate.isLeft(lower);
				String upline = node1DAO
						.findDisplayName(Generate.parent(lower));
				add(map, lower, upline, isLeft);
			}
			lower++;
		}
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

	private static void add(Map<String, String> map, Long pos, String upline,
			boolean left) {
		StringBuilder upl = new StringBuilder().append(upline);
		String strl = (left) ? " ช้าย" : " ขวา";
		upl.append(strl);
		map.put(pos.toString(), upl.toString());
	}

	private static Logger log = Logger.getLogger(FetchUplineServiceImp.class);

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

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

}
