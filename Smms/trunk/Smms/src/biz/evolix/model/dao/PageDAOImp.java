package biz.evolix.model.dao;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Page;
import biz.evolix.model.dao.callback.FindByCondition1;

@Repository
@Transactional
public class PageDAOImp extends JpaDaoSupport implements PageDAO{

	@Override
	@Transactional
	public String lookup(String id) {
		String result = null;
		try{
			result = getJpaTemplate().execute(new FindByCondition1<String>(id, "lookup"));
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}
	private static Logger log = Logger.getLogger(PageDAOImp.class);
	@Override
	@Transactional
	public void insert(Page p) {
		try{
			getJpaTemplate().persist(p);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}		
	}
}
