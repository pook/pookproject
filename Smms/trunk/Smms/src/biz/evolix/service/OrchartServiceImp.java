package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evlix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.Users;
import biz.evolix.model.bean.UserBean;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.secure.SmileUser;

public class OrchartServiceImp implements OrchartService {
	private static final Node1 NULL_NODE;
	static {
		NULL_NODE = new Node1();
		NULL_NODE.setNId(-2L);
		NULL_NODE.setCommissions(0);
		Users u = new Users();
		u.setUserId(" ");
		NULL_NODE.setUser(u);
		NULL_NODE.setDisplayName(" ");
	}
	private static final UserBean NULL_USER = new UserBean();
	private static Logger log = Logger.getLogger(OrchartServiceImp.class);
	private Long header;
	@Autowired
	private Node1DAO node1DAO;

	public void init() {
		try {
			setHeader();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public List<UserBean> getTeamLevel(Long id) {
		List<Node1> teams = new ArrayList<Node1>();
		List<UserBean> teams2 = new ArrayList<UserBean>();
		Long c = 0L;
		if (id < getHeader()) {
			id = getHeader();
		}
		Node1 n = getNode(id);
		if (n == null)
			return teams2;
		addList(teams, teams2, n);
		for (int i = 0; i < ConstType.MAX_NODE_SHOW; i++) {
			Node1 n1 = null, n2 = null;
			try {
				c = teams.get(i).getNId();
			} catch (Exception e) {
				log.equals(e.getMessage());
				break;
			}
			n1 = getNode(Generate.getLeftChildId(c));
			addList(teams, teams2, n1);
			n2 = getNode(Generate.getRightChildId(c));
			addList(teams, teams2, n2);
		}
		xCommission(teams);
		return teams2;
	}

	private void addList(List<Node1> teams, List<UserBean> teams2, Node1 n1) {
		if (n1 == null) {
			teams.add(teams.size(), NULL_NODE);
			teams2.add(teams2.size(), NULL_USER);
		} else {
			teams.add(teams.size(), n1);
			teams2.add(teams2.size(), new UserBean(n1.getUser().getUserId(), n1
					.getNId().toString(), n1.getDisplayName(), n1.getUser()
					.getInviter(), n1.getStatus()));
		}
	}

	private Node1 getNode(long c) {
		Node1 node = null;
		try {
			node = node1DAO.getNode1(c);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return node;
	}
	private List<Integer>levels;
	private void xCommission(List<Node1> teams){
		this.levels = new ArrayList<Integer>();
		for (int i = 0, k = 0; i < ConstType.BACKWARD_6 && k < teams.size(); i++) {
			int value = 0;
			int c = (int) Math.floor(Generate.math2Pow(i));
			for (int j = 0; j < c; j++) {
				try {
					value += teams.get(k++).getCommissions();
				} catch (IndexOutOfBoundsException e) {
					log.error(e.getMessage(), e);
					break;
				}
			}
			this.levels.add(value);
		}
	}
	@Override
	public List<Integer> levelCommissions() {
		return this.levels;
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	private Long getHeader() {
		return header;
	}

	private void setHeader() throws Exception {
		this.header = getUsers().getNode().getNId();
	}

	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public long getNodeId(String node) {
		Node1 n = node1DAO.getNode1FromUserId(node);
		if (n == null)
			return ConstType.NOT_FOUND;
		else if (n.getNId() < getHeader()) {
			return ConstType.NOT_ALLOW;
		} else if (!searchParent(n.getNId(), getHeader())) {
			return ConstType.NOT_ALLOW;
		}
		return n.getNId();
	}

	private static boolean searchParent(long id, long head) {
		while (id >= head) {
			if (id == head)
				return true;
			id = Generate.getParentId(id);
		}
		return false;
	}

}
