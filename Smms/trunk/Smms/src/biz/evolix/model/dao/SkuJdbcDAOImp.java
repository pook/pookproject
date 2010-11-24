package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SkuJdbcDAOImp extends JdbcDaoSupport implements SkuJdbcDAO {
	
	@Override
	public int size() {
		int c  = -1;
		try{
			c =getJdbcTemplate().queryForInt("select count(0) from SKU");
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}		 
		return 	c;	
	}	
	private static Logger log = Logger.getLogger(SkuJdbcDAOImp.class);
}
