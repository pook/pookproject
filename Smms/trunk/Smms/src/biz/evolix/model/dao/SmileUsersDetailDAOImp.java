package biz.evolix.model.dao;

import org.apache.log4j.Logger;

import org.eclipse.persistence.exceptions.DatabaseException;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.Province;
import biz.evolix.model.SmileUsersDetails;
import biz.evolix.model.dao.callback.FindByCondition1;

@Repository
@Transactional(rollbackFor = { Exception.class, DatabaseException.class }, isolation = Isolation.DEFAULT)
public class SmileUsersDetailDAOImp extends JpaDaoSupport implements
		SmileUsersDetailDAO {

	private static Logger log = Logger.getLogger(SmileUsersDetailDAOImp.class);

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void register(SmileUsersDetails smileuser) throws DatabaseException {
		try {
			getJpaTemplate().persist(smileuser);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Transactional(readOnly = true)
	public Province province(String id) {
		return getJpaTemplate().find(Province.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public SmileUsersDetails find(String smileId) {
		SmileUsersDetails sm = null;
		try {
			sm = getJpaTemplate().find(SmileUsersDetails.class, smileId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return sm;
	}

	@Override
	@Transactional
	public void update(SmileUsersDetails smileuser) {
		try {
			getJpaTemplate().merge(smileuser);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public int findCode(String codeId) {
		long f = ConstType.NOT_FOUND;		
		try {
			f = getJpaTemplate().execute(
					new FindByCondition1<Long>(codeId, "findcodeId"));
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
		return (int)f;
	}
}
