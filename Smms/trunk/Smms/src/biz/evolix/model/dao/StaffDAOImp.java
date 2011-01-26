package biz.evolix.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Staff;
import biz.evolix.model.Users;
import biz.evolix.model.dao.callback.FindAll;
import biz.evolix.model.dao.callback.MaxResultCon1;
import biz.evolix.model.dao.callback.UpdateCon2;

@Repository
public class StaffDAOImp extends JpaDaoSupport implements StaffDAO {

	@Override
	@Transactional(readOnly = true)
	public Staff find(long userId) {
		Staff staff = null;
		try {
			staff = getJpaTemplate().find(Staff.class, userId);
		} catch (Exception e) {
		
		}
		return staff;
	}
	@Override	
	public Staff find2(long userId) {
		Staff staff = null;
		try {
			staff = getJpaTemplate().find(Staff.class, userId);
		} catch (Exception e) {
		
		}
		return staff;
	}

	@Override
	@Transactional
	public void persist(Staff staff) {
		try {
			getJpaTemplate().persist(staff);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private static Logger log = Logger.getLogger(StaffDAOImp.class);

	@Override
	@Transactional
	public void remove(Staff staff) {
		try {			
			Staff s = getJpaTemplate().find(Staff.class,staff);
			getJpaTemplate().remove(s);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public long size() {
		long s = 0;
		try {
			s = getJpaTemplate().execute(new FindAll<Long>("staffsize"));
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Users> findAllStaff(int start,int max) {
		List<Users> users = new ArrayList<Users>();
		try {
			users = getJpaTemplate().executeFind(
					new MaxResultCon1<Users>(Role.ROLE_STAFF.name(),start,max,"findAllStaff"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return users;
	}

	@Override
	@Transactional
	public void merg(Staff staff) {
		try{
			getJpaTemplate().merge(staff);
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	@Override
	@Transactional
	public void update(Object arg0, Object arg1, String nameQuery) {
		try{
			getJpaTemplate().execute(new UpdateCon2<Long>(arg0, arg1, nameQuery));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}		
	}
}
