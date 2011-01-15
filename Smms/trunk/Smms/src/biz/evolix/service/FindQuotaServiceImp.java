package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.Users;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class FindQuotaServiceImp implements FindQuotaService {

	@Autowired
	private Node1DAO node1DAO;
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public int quota() {
		Node1 node = node1DAO.find2(new NodePK(getUsers().getTreeId(),
				getUsers().getPos()));
		int next = -1, quata = -1;
		Users user = usersDAO.find(getUsers().getUserid());
		next = user.getNumberOfAccount();		
		quata =usersDAO.findNumAccountQuota(user.getUserId());		
		quata =(node.getCommissions() > ConstType.COMMISION_BONUS && next < 3)? 
			 usersDAO.findNextQuota(++next, user.getDetail()):-1;	
		return quata;
	}

	public void setNode1DAO(Node1DAO node1DAO) {
		this.node1DAO = node1DAO;
	}

	public Node1DAO getNode1DAO() {
		return node1DAO;
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

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	private static Logger log = Logger.getLogger(FindQuotaServiceImp.class);
}
