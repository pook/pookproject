package biz.evolix.service.sub;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Authorities;
import biz.evolix.model.Users;
import biz.evolix.model.bean.UserBean;
import biz.evolix.model.bean.UserRoleBean;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.Role;
import biz.evolix.model.dao.UsersDAO;

public class RoleServiceImp implements RoleService {

	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Override
	public Integer sizeOfRevCard() {
		long x = usersDAO.sizeRevCard();
		return (int) x;
	}

	@Override
	public List<UserBean> userNotRevCard(int start, int max) {
		List<Users> user = usersDAO.userRecCard(start, max);
		ub = new ArrayList<UserBean>();
		for (int i = 0; i < user.size(); i++)
			ub.add(new UserBean(i, user.get(i).getNode1().getSmileId(), user
					.get(i).getDetail().getName(), user.get(i).getDetail()
					.getSurename(), user.get(i).getNode1().getDisplayName(),
					user.get(i).getBrance(), user.get(i).getBranceCard(),user.get(i).getDate()));
		return ub;
	}
	private List<UserBean> ub ;
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	@Override
	public void updateCard(String userIds) {
		String[] rowstr = userIds.split(",");List<Integer>rows = new ArrayList<Integer>();	
		for(String row : rowstr)rows.add(new Integer(row));		
		try {
			for (int row : rows)
				usersDAO.updateQuery(ub.get(row).getDisplayName(),"updateCard");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		usersDAO.flush();
	}

	@Override
	public Integer sizeMember() {
		long l = usersDAO.size();
		return (int) l;
	}

	@Override
	public List<UserRoleBean> userRole(int start, int max) {
		users = usersDAO.find(start, max);		
		return find(users);
	}
	private List<UserRoleBean>find(List<Users>users){
		List<UserRoleBean> roles = new ArrayList<UserRoleBean>();
		for (int i = 0; i < users.size(); i++) {
			Collection<Authorities> auth = users.get(i).getAuthorities();
			UserRoleBean b = new UserRoleBean(i, users.get(i).getNode1().getSmileId()
					, users.get(i).getDetail().getName(), users
					.get(i).getMaxRegister(),users.get(i).getDetail().getTel());
			for (Authorities a : auth) {
				if (a.getAuthority().equals(Role.ROLE_MEMBER.name())) {
					b.setMember(true);
				} else if (a.getAuthority().equals(Role.ROLE_ADMIN.name())) {
					b.setAdmin(true);
				} else if (a.getAuthority().equals(Role.ROLE_STAFF.name())) {
					b.setStaff(true);
				}
			}
			roles.add(b);
		}
		return roles;
	}

	private static Logger log = Logger.getLogger(RoleServiceImp.class);

	private List<Users> users;

	@Override
	public void updateRole(UserRoleBean roleb) {
		int idx = roleb.getId();
		Users user = users.get(idx);
		if (user != null) {	
			addRole(user, roleb.getAdmin(), Role.ROLE_ADMIN.name());
			addRole(user, roleb.getMember(), Role.ROLE_MEMBER.name());
			addRole(user, roleb.getStaff(), Role.ROLE_STAFF.name());
			user.setMaxRegister(roleb.getMaxuser());
			try {
				usersDAO.update(user);			
				usersDAO.flush();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	private void addRole(Users user,boolean hasRole,String role){
		Authorities auth = authoritiesDAO.findByName( role,user);
		if (hasRole){				
			if(auth == null){
				auth = new Authorities(user, role);
				authoritiesDAO.insert(auth);
				user.getAuthorities().add(auth);
			}else{
				user.getAuthorities().add(auth);
			}
		}else{
			if(user.getAuthorities().contains(auth)){
				user.getAuthorities().remove(auth);
			}
		}
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	@Override
	public List<UserRoleBean> search(String smileId) {
		Users user = usersDAO.findBySmileUser(smileId);
		users = new ArrayList<Users>();
		users.add(user);
		return find(users);
	}
}
