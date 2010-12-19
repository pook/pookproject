package biz.evolix.model.dao;

import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.id.common.OutOfLimitedIdException;
import biz.evolix.model.Node1;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.Province;
import biz.evolix.model.Users;


@Repository
@Transactional(isolation = Isolation.DEFAULT, rollbackFor = { Exception.class,
		DataAccessException.class,OutOfLimitedIdException.class })
public class RegisterDaoImp extends
		org.springframework.orm.jpa.support.JpaDaoSupport implements
		RegisterDAO {

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	public Users save(Users u, Long id, String pid, long n) {
		try {
			id = getID(id, n);
			String strId = Generate.getId(id, pid);
			u.setUserId(strId);
			u.getNode1().setUser(u.getUserId());
			u.getNode1().setNodeId(id);
			Province p = getJpaTemplate().find(Province.class, pid);
			u.setProvince(p);
			getJpaTemplate().persist(u.getNode1());
			getJpaTemplate().persist(u);
			getJpaTemplate().persist(new NodeDescription(id));
		} catch (Exception e) {
			log.error(e.getMessage() + " id =" + id, e);
			u = null;
		}
		return u;
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE)
	private Long getID(Long id, long n) throws DataAccessException,OutOfLimitedIdException {
		NodeDescription d = null;
		d = getDescription(n);
		boolean b = (id == ConstType.AUTO) ? true : false;
		if (!b) {
			for (int i = 0; i < 2; i++, id++) {
				if (getUserFromId(id) == null)
					return id;
			}
			b = true;
		}
		if (b) {
			id = d.getNextId();
			while (true) {
				if (getUserFromId(id) == null) {
					d.setNextId(id + 1);
					break;
				}
				id++;
			}
			long id2 = d.getNextId();
			update(d, id2);
		}
		return id;
	}

	@Transactional(readOnly = false,propagation=Propagation.REQUIRES_NEW)
	public void update(NodeDescription d, long id) {
		boolean b = false;
		try{
		while (getUserFromId(id++) != null)b = true;
		while ((id - 1) > d.getUpper()) {
			d.setLevel(d.getLevel() + 1);
			d.setLower(Generate.getLeftChildId(d.getLower()));
			d.setUpper(Generate.getLeftChildId(d.getUpper()) + 1);
			d.setNextId(d.getLower());
		}
		if (b)
			getJpaTemplate().merge(d);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Transactional(readOnly = true)
	private Node1 getUserFromId(Long id) throws NullPointerException {
		return getJpaTemplate().find(Node1.class, id);
	}

	@Transactional(readOnly = true)
	public NodeDescription getDescription(long id) {
		NodeDescription d = null;
		try {
			d = getJpaTemplate().find(NodeDescription.class, id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return d;
	}

	private static Logger log = Logger.getLogger(RegisterDaoImp.class);

	@Override
	public boolean checkLevel(long n) {
		return getDescription(n).getLevel() > 16;
	}
}
