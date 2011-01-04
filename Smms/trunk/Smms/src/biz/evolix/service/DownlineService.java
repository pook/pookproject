package biz.evolix.service;

import java.util.List;

import biz.evolix.model.bean.UserDowlineBean;

public interface DownlineService {
	public int size();
	public List<UserDowlineBean> downline(int start,int max);
}
