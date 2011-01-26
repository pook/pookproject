package biz.evolix.service;

import java.util.List;


import biz.evolix.model.Node1;
import biz.evolix.model.bean.NodeBean;

public interface OrchartService {
	public List<NodeBean> getTeamLevel(String treeId,long pos);
	public List<NodeBean> getTeamLevel(String treeId,long pos,int bw);
	public Node1 getNodeId(String  node);
	public List<Integer> levelCommissions();
	public void init();
}