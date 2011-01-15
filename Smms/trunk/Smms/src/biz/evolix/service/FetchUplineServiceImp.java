package biz.evolix.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.Utils;
import biz.evolix.gen.Generate;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.secure.SmileUser;

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
			return new HashMap<String, String>();
		NodePK id = new NodePK(head.getTreeId(), head.getPos());
		dept = nodeDeptDAO.find(id);
		String treeId = dept.getTreeId();
		long pos = dept.getPos();
		Map<String, String> map = new HashMap<String, String>();
		while (map.isEmpty()) {
			if (dept.getNextId() < dept.getPos()) {	
				log.info(">>>>8888888888>>>>>>>"+dept.getBaseLevel());
				List<String> hashs = Utils.hashCodes(treeId,dept.getBaseLevel(),pos);
				log.info(">>>>>>>>>>>"+hashs);
				for(String hash:hashs){
					long nextId = dept.getNextId();
					uplines2(dept,nextId,hash, map,false);
					log.info(">>>>>>>>>>>1>"+nextId);
				}
			} else {
				uplines2(dept, dept.getNextId(), treeId, map,true);
			}
			if (map.isEmpty()) {
				if (Generate.bottom(dept.getNextId())) {
					Utils.resetNodeDept(dept, true);
				} else
					Utils.updateNodeDept(dept.getUpper() + 1, dept, true);
			}
		}
		return map;
	}

	private void uplines2(NodeDescription dept, long lower, String treeId,
			Map<String, String> map,boolean test) {
		final long upper = dept.getUpper();
		List<Long> nonspace = node1DAO.findNonSpace(lower, upper,
				dept.getBaseLevel(), treeId);
		boolean isLeft = true;
		while (lower <= upper) {
			if (!nonspace.contains(lower)) {
				isLeft = Generate.isLeft(lower);
				String upline = node1DAO
						.findDisplayName(Generate.parent(lower));
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
		map.put(treeId + pos, upl.toString());
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
