package biz.evolix.model.dao;
import java.util.List;

import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;

public interface Node1DAO {
	public Node1 find(NodePK id);
	public Node1 find2(NodePK id);
	public Node1 findFromUserId(Long id);
	public Node1 findByHashCode(String hashCode);
	public Node1 findFromSmileId(String id);
	public List<Long> findNonSpace(long lower,long upper);
	public void persist(Node1 node);
	public void update(Node1 node);
	public String findDisplayName(long pos);
}
