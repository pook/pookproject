package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.Node1;
import biz.evolix.model.dao.callback.CheckDisplayName;

public class CheckDNameDAOImp extends JpaDaoSupport implements CheckDNameDAO {
	@Override
	public boolean test(String dname) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(new CheckDisplayName<Node1>(dname));
		} catch (Exception e) {
		}
		return n != null;
	}

	private static Logger log = Logger.getLogger(CheckDNameDAOImp.class);
}
