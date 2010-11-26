package biz.evolix.service;

import java.util.List;

import biz.evolix.model.bean.UserBean;

public interface OrchartService {
	public List<UserBean> getTeamLevel(Long  node);
	public long  getNodeId(String  node);
	public List<Integer> levelCommissions();
	public void init();
}
