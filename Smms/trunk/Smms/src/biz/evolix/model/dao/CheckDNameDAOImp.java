package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.dao.callback.CheckDisplayName;

public class CheckDNameDAOImp extends JpaDaoSupport implements CheckDNameDAO {
	@Override
	public boolean test(String dname) {		
		try {
			Long o = getJpaTemplate()
					.execute(new CheckDisplayName<Long>(dname));			
			return o>0;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}			
	}
	private static Logger log = Logger.getLogger(CheckDNameDAOImp.class);
}
