package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.secure.SmileUser;

public class OrchartServiceImp implements OrchartService {
	private static final Node1 NULL_NODE;
	static {
		NULL_NODE = new Node1();
		NULL_NODE.setTreeId("");
		NULL_NODE.setPos(-2L);
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

	public List<Node1> getTeamLevel(Long head) {
		List<Node1> teams = new ArrayList<Node1>();
		if (head < getHeader()) {
			head = getHeader();
		}
		NodePK id = new NodePK(getUsers().getTreeId(), head);
		Node1 n = node1DAO.find(id);
		if (n == null)
			return teams;
		addList(teams, n);
		for (int i = 0; i < ConstType.MAX_NODE_SHOW; i++) {
			Node1 n1 = null, n2 = null;			
			id.setPos(teams.get(i).getPos());
			n1 = node1DAO.find(new NodePK(ConstType.HASHCODE_NODE0, id.getLeft()));
			addList(teams, n1);
			n2 = node1DAO.find(new NodePK(ConstType.HASHCODE_NODE0, id.getRight()));
			addList(teams, n2);
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

	private List<Integer> levels;

	private void xCommission(List<Node1> teams) {
		this.levels = new ArrayList<Integer>();
		for (int i = 0, k = 0; i < ConstType.BACKWARD_6 && k < teams.size(); i++) {
			int value = 0;
			int c = (int) Math.floor(Generate.math2Pow(i));
			for (int j = 0; j < c; j++) {
				if(teams.get(k).getPos()==-2L)continue;
				value += teams.get(k++).getSv();				
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
		this.header = getUsers().getPos();
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
		Node1 n = node1DAO.findFromSmileId(node);		
		if (n == null)
			return ConstType.NOT_FOUND;
		else if (n.getPos() < getHeader()) {
			return ConstType.NOT_ALLOW;
		} else if (!searchParent(n.getPos(), getHeader())) {
			return ConstType.NOT_ALLOW;
		}
		return  n.getPos();
	}

	private static boolean searchParent(long id, long head) {
		while (id >= head) {
			if (id == head)
				return true;
			id = Generate.parent(id);
		}
		return false;
	}

}
