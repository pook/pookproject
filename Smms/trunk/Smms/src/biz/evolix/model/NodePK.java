package biz.evolix.model;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import biz.evolix.gen.Generate;

public class NodePK implements java.io.Serializable {
	private static final long serialVersionUID = -809139391916070346L;
	private static final String hashAlgorithm = "md5";

	private String treeId;
	private Long pos;
	public String getTreeId() {
		return treeId;
	}
	public void setTree(String treeId) {
		this.treeId = treeId;
	}	
	
	public NodePK(String treeId, Long pos) {
		super();
		this.pos = pos;
		this.treeId = treeId;
	}		
	public Long getPos() {
		return pos;
	}

	public void setPos(Long pos) {
		this.pos = pos;
	}	
	
	@Override
	public int hashCode() {
		final int p = 31;
		int r = 1;
		r = p * r + ((pos == null) ? 0 : pos.hashCode());
		r = p * r + ((treeId == null) ? 0 : treeId.hashCode());
		return r;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null ||getClass() != obj.getClass())
			return false;
		NodePK other = (NodePK) obj;
		if (pos == null || treeId == null) {			
			return false;
		} else if (!pos.equals(other.getPos())&&this.treeId!= other.getTreeId())
			return false;		
		return true;
	}

	public void next() {
		setPos(Generate.next(this.pos));		
	}
	public Long testNext(){
		return getPos()+1;
	}
	public void parent(){
		setPos(Generate.parent(this.pos));
	}
	public void left(){
		setPos(Generate.left(this.pos));
	}
	public void right(){
		setPos(Generate.right(this.pos));
	}
	public long getLeft(){
		return Generate.left(this.pos);
	}
	public long getRight(){
		return Generate.right(this.pos);
	}
	public long getParent(){
		return Generate.parent(this.pos);
	}
	public boolean isLeft(){
		return this.pos%2==0;
	}
	public String hashNode1() {
		try {
			return Generate.generateHashAlgorilthm(hashAlgorithm,getTreeId()+getPos());
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	private static Logger log = Logger.getLogger(NodePK.class);
}
