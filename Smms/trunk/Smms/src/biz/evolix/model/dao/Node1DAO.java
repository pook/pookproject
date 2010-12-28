package biz.evolix.model.dao;
import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;

public interface Node1DAO {
	public Node1 find(NodePK id);
	public Node1 find2(NodePK id);
	public Node1 findFromUserId(Long id);
	public Node1 findByHashCode(String hashCode);
	public Node1 findFromSmileId(String id);
	public void persist(Node1 node);
	public void update(Node1 node);
}
