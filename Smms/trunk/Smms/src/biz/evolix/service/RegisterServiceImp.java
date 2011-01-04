package biz.evolix.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.Authorities;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;
import biz.evolix.model.Province;
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.Users;
import biz.evolix.model.bean.Temp;
import biz.evolix.model.dao.AuthoritiesDAO;
import biz.evolix.model.dao.CheckDNameDAO;
import biz.evolix.model.dao.Node1DAO;
import biz.evolix.model.dao.NodeDeptDAO;
import biz.evolix.model.dao.Role;
import biz.evolix.model.dao.SmileUsersDetailDAO;
import biz.evolix.model.dao.UsersDAO;
import biz.evolix.secure.SmileUser;

public class RegisterServiceImp implements RegisterService {

	private final static Object LOCK = new Object();
	@Autowired
	private SmileUsersDetailDAO smileUsersDetailDAO;
	@Autowired
	private CheckDNameDAO checkNameDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private NodeDeptDAO nodeDeptDAO;
	@Autowired
	private Node1DAO node1DAO;
	@Autowired
	private UsersDAO userDAO;
	@Autowired
	private FindPlaceService findPlaceService;

	@Override
	public String save(SmileUsersDetails smileuser, String choseId,
			String pv, Node1 node, Users user) {
		SmileUser suser = getUsers();
		String treeId = (suser == null) ? ConstType.HASHCODE_NODE0 : getUsers()
				.getTreeId();
		Long pos = (suser == null) ? 0L : getUsers().getPos();
		long chose = -1;
		try {
			chose = Long.parseLong(choseId);
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
			throw new UsernameNotFoundException("Register Fail");
		}
		boolean auto = (chose == ConstType.AUTO) ? true : false;
		if (chose == -1)
			throw new UsernameNotFoundException("Register Fail");
		user.setNode1(node);
		user.setNumberOfAccount(1);
		if (!findPlace(new NodePK(treeId, pos), chose, node, false, auto))
			throw new UsernameNotFoundException("Register Fail");
		Province p = smileUsersDetailDAO.province(pv);
		smileuser.setProvince(p);
		smileuser.setNumOfAccount(1);
		String smileId = insert(smileuser, user, node, pv, chose);
		return smileId;
	}

	private String insert(SmileUsersDetails smileuser, Users user,
			Node1 node, String pv, Long userChoseId) {
		userDAO.persist(user);		
		user.setSmile(smileuser);
		smileUsersDetailDAO.register(smileuser);
		NodeDescription dept = nodeDeptDAO.find(new NodePK(node.getTreeId(),node.getPos()));
		node.setSmileId(Generate.smileId(user.getUserId(), dept.getBaseLevel(),pv));
		node.setUser(user.getUserId());
		node1DAO.update(node);
		Authorities auth = authoritiesDAO.findByName(Role.ROLE_MEMBER.name(),user);
		if(auth==null)
			auth = new Authorities(user, Role.ROLE_MEMBER.name());
		user.getAuthorities().add(auth);
		userDAO.update(user);
		return node.getSmileId();
	}

	private boolean findPlace(NodePK id, long choseId, Node1 node,
			boolean test, boolean auto) {
		String displayName = node.getDisplayName();
		NodeDescription dHead = nodeDeptDAO.find(id);
		NodePK id2 = null;
		Temp<Integer> level = new Temp<Integer>(dHead.getLevel());
		synchronized (LOCK) {
			if (checkDisplayName(displayName) && displayName.length() > 2) {
				id2 = findPlaceService.manual(choseId, id.getTreeId());
				auto = auto && (id2 == null) ? true : false;
				if (auto)
					id2 = findPlaceService.auto(dHead, auto, level);
				nodeDeptDAO.insert(new NodeDescription(dHead.getBaseLevel() + level.getTemp(),id2));
				node.setTreeId(id2.getTreeId());
				node.setPos(id2.getPos());
				node1DAO.persist(node);
				nodeDeptDAO.flush();
				test = true;
			}
		}
		return test;
	}

	private boolean checkDisplayName(String displayName) {
		return !checkNameDAO.test(displayName);
	}

	private static Logger log = Logger.getLogger(RegisterServiceImp.class);

	private SmileUser getUsers() {
		try {
			return (SmileUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean checkLevel() {
		// return registerDAO.checkLevel(getUsers().getNodeId());
		return false;
	}

	public void setSmileUsersDetailDAO(SmileUsersDetailDAO smileUsersDetailDAO) {
		this.smileUsersDetailDAO = smileUsersDetailDAO;
	}

	public SmileUsersDetailDAO getSmileUsersDetailDAO() {
		return smileUsersDetailDAO;
	}

	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}

	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}

	public void setNodeDeptDAO(NodeDeptDAO nodeDeptDAO) {
		this.nodeDeptDAO = nodeDeptDAO;
	}

	public NodeDeptDAO getNodeDeptDAO() {
		return nodeDeptDAO;
	}

	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UsersDAO getUserDAO() {
		return userDAO;
	}

	public void setFindPlaceService(FindPlaceService findPlaceService) {
		this.findPlaceService = findPlaceService;
	}

	public FindPlaceService getFindPlaceService() {
		return findPlaceService;
	}
}