package biz.evolix.model.dao;

import biz.evolix.model.News;

public interface NewsDAO {	
	public News loadNotice();
	public void saveNotice(News notice);
	public News loadActivity();
	public void saveActivity(News activity);
}
