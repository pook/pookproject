package biz.evolix.model.dao;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;


public interface NodeDeptDAO {
	public NodeDescription find(NodePK id);	
	public boolean insert(NodeDescription nodeDept);
	public void update(NodeDescription dept);
	public void flush();
}