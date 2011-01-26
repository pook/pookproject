package biz.evolix.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.secure.SmileUser;
import biz.evolix.utils.Comapare;
import biz.evolix.utils.Utils;

public class FetchUplineServiceImp implements FetchUplineService {

	// private static final int MAX = 128;

	@Autowired
	private NodeDeptDAO nodeDeptDAO;
	@Autowired
	private Node1DAO node1DAO;

	@Override
	public Map<String, String> uplines() {
		NodeDescription dept = null;
		SmileUser head = getUsers();
		if (head == null)
			return new TreeMap<String, String>();
		NodePK id = new NodePK(head.getTreeId(), head.getPos());		
		dept = nodeDeptDAO.find(id);
		String treeId = dept.getTreeId();
		long pos = dept.getPos();
		Map<String, String> map = new TreeMap<String, String>(
				new Comapare<String>());
		while (map.isEmpty()) {
			if (dept.getNextId() < dept.getPos()) {
				List<String> hashs = Utils.hashCodes(treeId,
						dept.getBaseLevel(), pos);				
				for (String hash : hashs) {
					long next = dept.getLower();
					uplines2(dept.getUpper(),next,dept.getBaseLevel(),dept.getHigh(), hash, map, false);
				}
			} else {		
				long next = dept.getNextId();
				uplines2(dept.getUpper(),next,dept.getBaseLevel(),dept.getHigh(), treeId, map, true);
			}
			if (map.isEmpty()) {				
				if (Utils.inRange(dept.getNextId())) {
					Utils.resetNodeDept(dept, true);					
				} else
					Utils.updateNodeDept(dept.getUpper() + 1, dept, true);
				nodeDeptDAO.update(dept);
			}
		}
		return map;
	}

	private void uplines2(final long upper, long lower,final int baseLevel,final int high, String treeId,
			Map<String, String> map, boolean test) {		
		List<Long> nonspace = node1DAO.findNonSpace(lower, upper, treeId);
		boolean isLeft = true;
		while (lower <= upper) {
			if (!nonspace.contains(lower)) {
				isLeft = Generate.isLeft(lower);
				long parent = Generate.parent(lower);
				String upline = node1DAO.findDisplayName(parent, treeId);				
				upline =  (parent == 1 && upline == null) ? nodeDeptDAO.find(treeId) : upline;
				add(map, lower, treeId, upline, isLeft);
			}
			lower++;
		}
	}

	private static void add(Map<String, String> map, long pos, String treeId,
			String upline, boolean left) {
		StringBuilder upl = new StringBuilder().append(upline);
		String strl = (left) ? " ช้าย" : " ขวา";
		upl.append(strl);
		map.put(new StringBuilder().append(treeId).append(pos).toString(),
				upl.toString());
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
