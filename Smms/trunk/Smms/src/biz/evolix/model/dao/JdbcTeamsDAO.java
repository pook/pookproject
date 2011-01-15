package biz.evolix.model.dao;

import java.util.List;

import biz.evolix.model.bean.UserDowlineBean;



public interface JdbcTeamsDAO {
	public int size();
	public List<UserDowlineBean> find(int from,int max);
}
