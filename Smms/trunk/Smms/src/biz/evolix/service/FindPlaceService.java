package biz.evolix.service;

import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;

public interface FindPlaceService {
	public NodePK manual(long chose,String treeId);
	public NodePK auto(NodeDescription dHead,boolean auto);
}
