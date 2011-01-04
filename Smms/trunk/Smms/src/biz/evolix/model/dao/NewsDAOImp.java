package biz.evolix.model.dao;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.customconst.ConstType;
import biz.evolix.model.News;

@Repository
@Transactional
public class NewsDAOImp extends JpaDaoSupport implements NewsDAO {

	@Override
	@Transactional(readOnly = true)
	public News loadNotice() {		
		return getJpaTemplate().find(News.class,ConstType.NOTICE );
	}

	@Override
	public void saveNotice(News notice) {
		getJpaTemplate().merge(notice);		
	}

	@Override
	@Transactional(readOnly = true)
	public News loadActivity() {		
		return getJpaTemplate().find(News.class,ConstType.ACTIVITY);
	}

	@Override
	public void saveActivity(News activity) {
		getJpaTemplate().merge(activity);		
	}	
}
