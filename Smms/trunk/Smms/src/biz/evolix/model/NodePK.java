package biz.evolix.model;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import biz.evolix.gen.Generate;

public class NodePK {
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

	public NodePK() {
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
		if (obj == null || getClass() != obj.getClass())
			return false;
		NodePK other = (NodePK) obj;
		if (pos == null || treeId == null) {
			return false;
		} else if (!pos.equals(other.getPos())
				&& this.treeId != other.getTreeId())
			return false;
		return true;
	}

	public long testNext() {
		return getPos() + 1;
	}

	public String hashNode1() {
		return hashNode1(getTreeId() + getPos());
	}

	public static String hashNode1(String id) {
		try {
			return Generate.generateHashAlgorilthm(HASH_ALGORITHM, id);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	private static Logger log = Logger.getLogger(NodePK.class);
}