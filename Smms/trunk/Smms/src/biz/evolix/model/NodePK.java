package biz.evolix.model;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;

public class NodePK implements java.io.Serializable {
	private static final long serialVersionUID = -809139391916070346L;
	private static final String HASH_ALGORITHM = "md5";

	private String treeId;
	private Long pos;
	public String getTreeId() {
		return treeId;
	}
	public void setTree(String treeId) {
		this.treeId = treeId;
	}	
	
	public NodePK(String treeId, long pos) {
		super();
		this.pos = pos;
		this.treeId = treeId;
	}		
	public Long getPos() {
		return pos;
	}

	public void setPos(long pos) {
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
		if(this.pos<ConstType.MAX_NODE63)
			setPos(++pos);
		else
			goNext();				
	}
	public long testNext(){
		return getPos()+1;
	}
	public void parent(){
		setPos(Generate.parent(this.pos));
	}
	public void left(){
		if(this.pos<ConstType.MAX_NODE62)
			setPos(Generate.left(this.pos));
		else
			setPos(goLeft());		
	}
	public void right(){
		if(this.pos<ConstType.MAX_NODE62)
			setPos(Generate.right(this.pos));
		else
			setPos(goRight());
	}
	public NodePK getLeft(){
		return (this.pos<ConstType.MAX_NODE62)?new NodePK(getTreeId(),Generate.left(this.pos)):testGoLeft();
	}
	public NodePK getRight(){
		return (this.pos<ConstType.MAX_NODE62)?new NodePK(getTreeId(),Generate.right(this.pos)):testGoRight();
	}
	public long getParent(){
		return Generate.parent(this.pos);
	}
	public boolean isLeft(){
		return this.pos%2==0;
	}
	
	public String hashNode1() {
		try {
			return Generate.generateHashAlgorilthm(HASH_ALGORITHM,getTreeId()+getPos());
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	private long goLeft(){		
		setPos(2);
		setTree(this.hashNode1());		
		return getPos();
	}
	private long goRight(){
		setPos(3);
		setTree(this.hashNode1());		
		return getPos();
	}
	private long goNext(){
		              	
		return getPos();
	}
	private NodePK testGoLeft(){			
		return new NodePK(this.hashNode1(), 2);
	}
	private NodePK testGoRight(){
		return new NodePK(this.hashNode1(), 3);
	}
	private static Logger log = Logger.getLogger(NodePK.class);
}
