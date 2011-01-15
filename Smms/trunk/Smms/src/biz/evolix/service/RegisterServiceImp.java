package biz.evolix.service;

import java.util.Date;

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
	@Autowired
	private FindQuotaService findQuotaService;

	@Override
	public String save(SmileUsersDetails smileuser, String choseId, String pv,
			Node1 node, Users user) {
		SmileUser suser = getUsers();
		String treeId = (suser == null) ? ConstType.HASHCODE_NODE0 : getUsers()
				.getTreeId();
		long pos = (suser == null) ? 0L : getUsers().getPos();
		long chose = -1;
		String choseTree = treeId;
		boolean test = false;
		if (choseId.length() == 2) {
			try {
				chose = Long.parseLong(choseId);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new UsernameNotFoundException("Register Fail");
			}
		} else {
			try {
				choseTree = choseId.substring(0, 32);
				chose = Long.parseLong(choseId.substring(32));
				test = true;
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new UsernameNotFoundException("Register Fail");
			}
		}
		boolean auto = (chose == ConstType.AUTO) ? true : false;
		if (chose == -1)
			throw new UsernameNotFoundException("Register Fail");
		user.setNode1(node);
		user.setNumberOfAccount(1);
		user.setMaxRegister(0);
		if (!findPlace(new NodePK(treeId, pos), choseTree, chose, node, test,
				auto))
			throw new UsernameNotFoundException("Register Fail");
		Province p = smileUsersDetailDAO.province(pv);
		smileuser.setProvince(p);
		smileuser.setNumOfAccount(1);
		user.setDetail(smileuser);
		smileUsersDetailDAO.register(smileuser);		
		String smileId = insert(smileuser, user, node, pv, chose);
		if (getUsers() != null) {
			Users inviter = userDAO.find(getUsers().getUserid());
			inviter.setMaxRegister(inviter.getMaxRegister() - 1);
			userDAO.update(inviter);
		}
		return smileId;
	}

	public String save2(String choseId, String displayName) {
		String treeId = getUsers().getTreeId();
		long pos = getUsers().getPos();
		long chose = -1;
		String choseTree = treeId;
		boolean test = false;
		if (choseId.length() == 2) {
			try {
				chose = Long.parseLong(choseId);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new UsernameNotFoundException("Register Fail");
			}
		} else {
			try {
				choseTree = choseId.substring(0, 32);
				chose = Long.parseLong(choseId.substring(32));
				test = true;
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new UsernameNotFoundException("Register Fail");
			}
		}
		Users inviter = userDAO.find(getUsers().getUserid());
		SmileUsersDetails smile = inviter.getDetail();		
		if (inviter.getNumberOfAccount() > 2 || findQuotaService.quota() != 0){			
			throw new UsernameNotFoundException("Register Fail");
			}
		boolean auto = (chose == ConstType.AUTO) ? true : false;
		Node1 node = new Node1();
		node.setInviter(getUsers().getDisplayName());
		node.setDisplayName(displayName);
		if (chose == -1)
			throw new UsernameNotFoundException("Register Fail");
		if (!findPlace(new NodePK(treeId, pos), choseTree, chose, node, test,
				auto))
			throw new UsernameNotFoundException("Register Fail");
		Users user = new Users();		
		user.setPassword(ConstType.DEFAULT_PW);
		user.setBrance(inviter.getBrance());
		user.setBranceCard(inviter.getBranceCard());
		user.setDate(new Date());
		user.setNode1(node);
		int inv = inviter.getNumberOfAccount() + 1;
		user.setNumberOfAccount(inv);		
		smile.setNumOfAccount(inv);			
		user.setDetail(smile);		
		String smileId = insert(smile, user, node, inviter
				.getDetail().getProvince().getpCode(), chose);
		smile.getUsers().add(user);
		smileUsersDetailDAO.update(smile);
		if (getUsers() != null) {			
			Users inviter1 = userDAO.find(getUsers().getUserid());
			inviter.setMaxRegister(inviter.getMaxRegister() - 1);
			userDAO.update(inviter1);
		}
		return smileId;
	}

	private String insert(SmileUsersDetails smileuser, Users user, Node1 node,
			String pv, Long userChoseId) {	
		userDAO.persist(user);
		NodeDescription dept = nodeDeptDAO.find(new NodePK(node.getTreeId(),
				node.getPos()));
		node.setSmileId(Generate.smileId(user.getUserId(), dept.getBaseLevel(),
				pv));
		node.setUser(user.getUserId());
		node1DAO.update(node);
		Authorities auth = authoritiesDAO.findByName(Role.ROLE_MEMBER.name(),
				user);
		if (auth == null)
			auth = new Authorities(user, Role.ROLE_MEMBER.name());
		user.getAuthorities().add(auth);
		userDAO.update(user);
		return node.getSmileId();
	}

	private boolean findPlace(NodePK id, String treeId, long choseId,
			Node1 node, boolean test, boolean auto) {
		String displayName = node.getDisplayName();
		boolean success = false;
		NodeDescription dHead = nodeDeptDAO.find(id);
		NodePK id2 = null;
		Temp<Integer> level = new Temp<Integer>(dHead.getHigh());
		synchronized (LOCK) {
			if (checkDisplayName(displayName) && displayName.length() > 2) {
				id2 = findPlaceService.manual(choseId, treeId);
				auto = auto && (id2 == null) ? true : false;
				if (auto)
					id2 = findPlaceService.auto(dHead, treeId, auto, level,
							test);
				nodeDeptDAO.insert(new NodeDescription(dHead.getBaseLevel()
						+ level.getTemp(), id2));
				node.setTreeId(id2.getTreeId());
				node.setPos(id2.getPos());
				node1DAO.persist(node);
				nodeDeptDAO.flush();
				success = true;
			}
		}
		return success;
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

	@Override
	public String save(String cid, String displayName) {
		return save2(cid, displayName);
	}

	public void setFindQuotaService(FindQuotaService findQuotaService) {
		this.findQuotaService = findQuotaService;
	}

	public FindQuotaService getFindQuotaService() {
		return findQuotaService;
	}
}