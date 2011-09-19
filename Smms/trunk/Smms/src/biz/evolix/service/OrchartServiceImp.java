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
import biz.evolix.model.bean.NodeBean;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.secure.SmileUser;
import biz.evolix.utils.Utils;

public class OrchartServiceImp extends AbstractController implements OrchartService {
	private static final Node1 NULL_NODE;
	private static final NodeBean NULL_NODEB = new NodeBean();
	static {
		NULL_NODE = new Node1();
		NULL_NODE.setTreeId("");
		NULL_NODE.setPos(-2L);
		NULL_NODE.setSv(0);
	}
	private static Logger log = Logger.getLogger(OrchartServiceImp.class);
	private String treeid;
	private String tree2;
	private long pos;
	@Autowired
	private Node1DAO node1DAO;

	@Override
	public void init() {
		this.treeid = getUsers().getTreeId();
		this.pos = getUsers().getPos();
	}

	@Override
	public List<NodeBean> getTeamLevel(String treeId, long pos, int bw) {
		switch (bw) {
		case ConstType.BACKWARD:
			pos = backward(treeId, pos);
			return getTeamLevel(this.tree2, pos);
		case ConstType.BACKWARD_6:
			pos = backward6(treeId, pos);
			return getTeamLevel(this.tree2, pos);
		default:
			return getTeamLevel(this.treeid, new Long(ConstType.NOT_FOUND));
		}
	}

	@Override
	public List<NodeBean> getTeamLevel(String treeId, long head) {
		if (head == ConstType.AUTO || head < this.pos
				&& treeId.equals(this.treeid)) {
			head = this.pos;
			treeId = this.treeid;
		}
		return getTeamLevel1(treeId, head);
	}

	private List<NodeBean> getTeamLevel1(String treeId, long head) {
		NodePK id = new NodePK(treeId, head);
		Node1 n = node1DAO.find(id);
		List<Node1> teams = new ArrayList<Node1>();
		List<NodeBean> teams1 = new ArrayList<NodeBean>();
		if (n == null)
			return teams1;
		addList(teams, n, teams1);
		for (int i = 0; i < ConstType.MAX_NODE_SHOW; i++) {
			long left=new Long(-1),right = new Long(-1);
			id = new NodePK(teams.get(i).getTreeId(), teams.get(i).getPos());			
			if (Utils.inRange(id.getPos())) {
				treeId = NodePK.hashNode1(id.getTreeId() + id.getPos());
				left = new Long(2);
				right = new Long(3);
			}else{
				left = Generate.left(id.getPos());
				right = Generate.right(id.getPos());
				treeId = id.getTreeId();
			}
			Node1 n1 = node1DAO.find(new NodePK(treeId, left));
			addList(teams, n1, teams1);
			Node1 n2 = node1DAO.find(new NodePK(treeId, right));
			addList(teams, n2, teams1);			
		}
		xCommission(teams);
		return teams1;
	}

	private synchronized void addList(List<Node1> teams, Node1 n1, List<NodeBean> teams1) {
		if (n1 == null) {
			teams.add(teams.size(), NULL_NODE);
			teams1.add(teams1.size(), NULL_NODEB);
		} else {
			teams.add(teams.size(), n1);
			teams1.add(teams1.size(),
					new NodeBean(n1.getSmileId(), n1.getTreeId(), n1.getPos()
							+ "", n1.getInviter(), n1.getDisplayName(),n1.getStatus()));
		}
	}

	private List<Integer> levels;

	private void xCommission(List<Node1> teams) {
		this.levels = new ArrayList<Integer>();
		for (int i = 0, k = 0; i < ConstType.BACKWARD_6 && k < teams.size(); i++) {
			int value = 0;
			int c = (int) Math.floor(Generate.math2Pow(i));
			for (int j = 0; j < c; j++) {				
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

	@Override
	public Node1 getNodeId(String node) {
		Node1 n = node1DAO.findFromSmileId(node);
		if (n == null)
			return new Node1(new Long(-2L));
		else if (!searchParent(n.getPos(), this.pos, n.getTreeId())) {
			return new Node1(new Long(-3L));
		}
		return n;
	}

	private boolean searchParent(long id, long head, String treeId) {
		if (treeId.equals(this.treeid)) {
			return id < head || searchParent(id, head);
		} else {
			final long id2 = new Long(1);
			while (id > id2)
				id = Generate.parent(id);
			Node1 n = node1DAO.findByHashCode(treeId);
			return searchParent(n.getPos(), head);
		}
	}

	private static boolean searchParent(long id, long head) {
		while (id >= head) {
			if (id == head)
				return true;
			id = Generate.parent(id);
		}
		return false;
	}

	private long backward(String treeId, long c) {
		this.tree2 = this.treeid;
		if (treeId.equals(this.treeid)) {
			return Generate.parent(c);
		} else {
			long p = Generate.parent(c);
			if (p == ConstType.ONE) {
				Node1 n = node1DAO.findByHashCode(treeId);
				this.tree2 = n.getTreeId();
				return n.getPos();
			}
			return p;
		}
	}

	private long backward6(String treeId, long c) {
		for (int i = 0; i < ConstType.BACKWARD_6; i++)
			c = backward(treeId, c);
		return c;
	}
}