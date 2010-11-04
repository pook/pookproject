package biz.evolix.service;

import java.util.List;

import biz.evolix.model.Node1;

public interface OrchartService {
	public List<Node1> getTeamLevel(Long  node);
	public List<Integer> levelCommissions(List<Node1> teams);
}
