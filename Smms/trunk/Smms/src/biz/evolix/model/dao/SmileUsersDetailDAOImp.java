package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.eclipse.persistence.exceptions.DatabaseException;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Province;
import biz.evolix.model.SmileUsersDetails;

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
	

}