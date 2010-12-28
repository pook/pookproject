package biz.evolix.model.dao;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;


public interface NodeDeptDAO {
	public NodeDescription find(NodePK id);
	public void updateNodeDept(long nxt,NodeDescription dept,boolean test);
	public boolean insert(NodeDescription nodeDept);
	public NodeDescription nextId(NodeDescription dHead,long useId, NodePK id,boolean auto);
	public void update(NodeDescription dept);
}
