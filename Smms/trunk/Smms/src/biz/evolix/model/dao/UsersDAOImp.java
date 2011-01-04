package biz.evolix.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.FindByCondition1;
import biz.evolix.model.dao.callback.GenericSize;
import biz.evolix.model.dao.callback.GenericSizeByCause;
import biz.evolix.model.dao.callback.MaxResult;
import biz.evolix.model.dao.callback.MaxResultCon1;
import biz.evolix.model.dao.callback.UpdateCon1;

@Repository
@Transactional(isolation = Isolation.DEFAULT)
public class UsersDAOImp extends JpaDaoSupport implements UsersDAO {

	private static Logger log = Logger.getLogger(UsersDAOImp.class);

	public Users find(Long id) {
		Users u = null;
		try {
			u = getJpaTemplate().find(Users.class, id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return u;
	}

	@Override
	@Transactional
	public void persist(Users user) {
		try {
			getJpaTemplate().persist(user);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public void update(Users user) {
		try {
			getJpaTemplate().merge(user);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Users findBySmileUser(String smileId) {
		Users user = null;
		try {
			user = getJpaTemplate().execute(
					new FindByCondition1<Users>(smileId, "finduser"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	@Transactional(readOnly = true)
	public Long sizeRevCard() {
		long i = -1;
		try {
			i = getJpaTemplate().execute(
					new GenericSize<Long>("receivecardSize"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return i;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Users> userRecCard(int start, int max) {
		List<Users> users = null;
		try {
			users = getJpaTemplate().executeFind(
					new MaxResult<Users>(start, max, "receivecard"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return users;
	}

	@Override
	@Transactional(readOnly = true)
	public Long size() {
		long i = -1;
		try {
			i = getJpaTemplate().execute(new GenericSize<Long>("userSize"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return i;
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Users> find(int start, int max) {
		List<Users> users = new ArrayList<Users>();
		try {
			users = (List<Users>) getJpaTemplate().executeFind(
					new MaxResult<Users>(start, max, "loadUser"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return users;
	}

	@Override
	public void updateQuery(long user, String nameQuery) {
		try {
			getJpaTemplate().execute(new UpdateCon1<Long>(null, nameQuery));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void flush() {
		try {
			getJpaTemplate().flush();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public long size(Object arg0) {
		long size = -1;
		try {
			size = getJpaTemplate().execute(
					new GenericSizeByCause<Long, Object>("userdownlinesize",
							arg0));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Users> find(int start, int max, Object arg0, String nameQuery) {
		List<Users> users = null;
		try {
			users = getJpaTemplate().executeFind(
					new MaxResultCon1<Users>(arg0, start, max, nameQuery));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return users;
	}

}
