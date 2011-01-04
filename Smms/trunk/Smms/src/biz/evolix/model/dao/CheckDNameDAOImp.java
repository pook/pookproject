package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import biz.evolix.model.Node1;
import biz.evolix.model.dao.callback.FindByCondition1;

public class CheckDNameDAOImp extends JpaDaoSupport implements CheckDNameDAO {
	@Override
	public boolean test(String dname) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(new FindByCondition1<Node1>(dname,"findDisplayName"));
		} catch (Exception e) {
		}
		return n != null;
	}

	private static Logger log = Logger.getLogger(CheckDNameDAOImp.class);
}