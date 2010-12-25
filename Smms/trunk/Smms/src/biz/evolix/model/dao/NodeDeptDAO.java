package biz.evolix.model.dao;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;


public interface NodeDeptDAO {
	public NodeDescription id(NodePK id);
	public void updateNodeDept(long nxt,NodeDescription dept);
	public boolean insert(NodeDescription nodeDept);
	public NodePK nextId(Long useId, String nodeId, Long pos);
	public void update(NodeDescription dept);
}
