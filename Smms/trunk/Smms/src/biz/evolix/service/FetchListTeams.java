package biz.evolix.service;

import java.util.List;

import biz.evolix.model.bean.UserDowlineBean;

public interface FetchListTeams {
	public int size();
	public List<UserDowlineBean> find(int start,int max);
}
