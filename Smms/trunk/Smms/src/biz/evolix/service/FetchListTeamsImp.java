package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import biz.evolix.gen.Generate;
import biz.evolix.model.Users;
import biz.evolix.model.bean.UserDowlineBean;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class FetchListTeamsImp implements FetchListTeams {
	
	@Autowired
	private UsersDAO usersDAO;
	
	private String query;
	@Override
	public int size() {	
		this.query = teams();
		StringBuilder sb = new StringBuilder();
		sb.append("select count(0)")
		.append(this.query);
		long size = usersDAO.size(sb.toString() );
		return (int)size;
	}

	@Override
	public List<UserDowlineBean> find(int start, int max) {
		StringBuilder sb = new StringBuilder();
		sb.append("select U ")
		.append(this.query);
		List<Users> users = usersDAO.find(start, max,sb.toString());
		return downline(users);
	}
	private List<UserDowlineBean> downline(List<Users> users) {
		List<UserDowlineBean> downs = new ArrayList<UserDowlineBean>();
		if (users == null)
			return downs;
		int i = 0;
		for (Users user : users) {
			downs.add(new UserDowlineBean(i++,user.getNode1().getSmileId(), user.getDetail().getName(), user.getDetail().getAddress(),
					user.getNode1().getDisplayName(),status(user.getNode1().getStatus())));
		}
		return downs;
	}

	private String teams(){
		long header = getUsers().getPos();//NodeDescription dept = nodeDeptDAO.find(new NodePK(getUsers().getTreeId(),header));
		//int high = dept.getHigh();
		int high = 16;
		StringBuilder sb = new StringBuilder();
		sb.append(" from Users U where U.node1.pos in (");
		for(int i=0;i<high;i++){
			int j = (int)Generate.math2Pow(i);
			for(int k=0;k<j;k++)
				sb.append(header+k).append(",");			
			header = Generate.left(header);
		}	
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return sb.toString();
	}
	

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
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
	private static String status(char status){
		switch (status) {
		case 'A':
			return "ACTIVE";
		default:
			return "INACTIVE";
		}
	}

}
