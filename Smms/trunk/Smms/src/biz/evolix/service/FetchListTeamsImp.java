package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.bean.Temp;
import biz.evolix.model.bean.UserDowlineBean;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.SmileUsersDetailDAO;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;
import biz.evolix.utils.Utils;

public class FetchListTeamsImp implements FetchListTeams {

	@Autowired
	private Node1DAO node1DAO;	
	
	@Autowired	
	private SmileUsersDetailDAO smileUsersDetailDAO;

	private List<UserDowlineBean> downlines;

	// private int size = 0;
	@Override
	public int size() {
		return this.downlines.size();
	}

	@Override
	public List<UserDowlineBean> find(int start, int max) {
		return this.downlines.subList(start, max);
	}

	public void downlines() {
		List<UserDowlineBean> downs = new ArrayList<UserDowlineBean>();
		NodePK id = new NodePK(getUsers().getTreeId(), getUsers().getPos());
		//preorder(node1DAO, id, new Temp(0), downs);
		levelOrder(id, downs);
		this.downlines = downs;
	}

	/*
	 * private List<UserDowlineBean> downline(List<Users> users,int start) {
	 * List<UserDowlineBean> downs = new ArrayList<UserDowlineBean>(); if (users
	 * == null) return downs; downs = preorder(id, idx, start, max, teams);
	 * return downs; }
	 */
	/*
	 * private List<UserDowlineBean> teams(){ long header =
	 * getUsers().getPos();//NodeDescription dept = nodeDeptDAO.find(new
	 * NodePK(getUsers().getTreeId(),header)); //int high = dept.getHigh();
	 * 
	 * int high = 16; StringBuilder sb = new StringBuilder();
	 * sb.append(" from Users U where U.node1.pos in (");
	 * 
	 * for(int i=0;i<high;i++){ int j = (int)Generate.math2Pow(i); / for(int
	 * k=0;k<j;k++) sb.append(header+k).append(","); header =
	 * Generate.left(header); }
	 * 
	 * 
	 * sb.deleteCharAt(sb.length()-1); sb.append(")"); //return sb.toString();
	 * 
	 * 
	 * 
	 * }
	 */
	private static void preorder(Node1DAO node1DAO, NodePK id,
			Temp<Integer> idx, List<UserDowlineBean> teams) {
		Node1 n = node1DAO.find(id);
		if (n == null) {
			return;
		} else {
			idx.setTemp(idx.getTemp() + 1);
			teams.add(new UserDowlineBean(idx.getTemp(), n.getSmileId(), n
					.getDisplayName(), n.getDisplayName(),
					status(n.getStatus())));
			long lft = new Long(-1), rht = new Long(-1);
			String treeId;
			if (Utils.inRange(id.getPos())) {
				treeId = NodePK.hashNode1(id.getTreeId() + id.getPos());
				lft = new Long(2);
				rht = new Long(3);
			} else {
				lft = Generate.left(id.getPos());
				rht = Generate.right(id.getPos());
				treeId = id.getTreeId();
			}
			preorder(node1DAO, new NodePK(treeId, lft), idx, teams);
			preorder(node1DAO, new NodePK(treeId, rht), idx, teams);
		}
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

	private static Logger log = Logger.getLogger(FetchListTeamsImp.class);

	private static String status(char status) {
		switch (status) {
		case 'A':
			return "ACTIVE";
		default:
			return "INACTIVE";
		}
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
	}

	public void setNode1DAO(Node1DAO node1dao) {
		this.node1DAO = node1dao;
	}

	private void levelOrder(NodePK node, List<UserDowlineBean> downs) {
		Stack<NodePK> stk = new Stack<NodePK>();
		stk.push(node);
		NodePK id = null;
		Node1 n = null, nl = null, nr = null;
		int idx = 0;
		while (!stk.isEmpty()) {
			id = stk.pop();
			n = node1DAO.find(id);
			//SmileUsersDetails s = smileUsersDetailDAO.find(n.getSmileId());
			downs.add(new UserDowlineBean(++idx, n.getSmileId(), n
			.getDisplayName(), n.getDisplayName(), status(n.getStatus())));
			long lft = new Long(-1), rht = new Long(-1);
			String treeId;
			if (Utils.inRange(id.getPos())) {
				treeId = NodePK.hashNode1(id.getTreeId() + id.getPos());
				lft = new Long(2);
				rht = new Long(3);
			} else {
				lft = Generate.left(id.getPos());
				rht = Generate.right(id.getPos());
				treeId = id.getTreeId();
			}			
			NodePK idl =new NodePK(treeId,lft);
			nl = node1DAO.find(idl);
			if(nl != null){
				stk.push(idl);
			}
			NodePK idr =new NodePK(treeId,rht);
			nr = node1DAO.find(idr);
			if(nr != null){
				stk.push(idr);
			}
		}
	}
	public void setSmileUsersDetailDAO(SmileUsersDetailDAO smileUsersDetailDAO) {
		this.smileUsersDetailDAO = smileUsersDetailDAO;
	}

	public SmileUsersDetailDAO getSmileUsersDetailDAO() {
		return smileUsersDetailDAO;
	}
}