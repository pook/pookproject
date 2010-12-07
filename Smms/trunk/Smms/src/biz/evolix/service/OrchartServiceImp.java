package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evlix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.secure.SmileUser;

public class OrchartServiceImp implements OrchartService {
	private static final Node1 NULL_NODE;
	static {
		NULL_NODE = new Node1();
		NULL_NODE.setNodeId(-2L);
	}
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

	public List<Node1> getTeamLevel(Long id) {
		List<Node1> teams = new ArrayList<Node1>();
		Long c = 0L;
		if (id < getHeader()) {
			id = getHeader();
		}
		Node1 n = getNode(id);
		if (n == null)
			return teams;
		addList(teams, n);
		log.info("not null;" + n.getNodeId());
		for (int i = 0; i < ConstType.MAX_NODE_SHOW; i++) {
			Node1 n1 = null, n2 = null;
			try {
				c = teams.get(i).getNodeId();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				break;
			}
			if (c != -2) {
				n1 = getNode(Generate.getLeftChildId(c));
				addList(teams, n1);
				n2 = getNode(Generate.getRightChildId(c));
				addList(teams, n2);
			}
		}
		xCommission(teams);
		return teams;
	}

	private void addList(List<Node1> teams, Node1 n1) {
		if (n1 == null)
			teams.add(teams.size(), NULL_NODE);
		else
			teams.add(teams.size(), n1);

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

	private List<Integer> levels;

	private void xCommission(List<Node1> teams) {
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
		this.header = getUsers().getNodeId();
		log.debug("head :" + this.header);
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
		else if (n.getNodeId() < getHeader()) {
			return ConstType.NOT_ALLOW;
		} else if (!searchParent(n.getNodeId(), getHeader())) {
			return ConstType.NOT_ALLOW;
		}
		return n.getNodeId();
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
