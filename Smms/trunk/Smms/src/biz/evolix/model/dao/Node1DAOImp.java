package biz.evolix.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Node1;
import biz.evolix.model.NodePK;
import biz.evolix.model.dao.callback.FindByCondition1;
import biz.evolix.model.dao.callback.FindListByCondition2;

@Repository
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class Node1DAOImp extends JpaDaoSupport implements Node1DAO {
	private static Logger log = Logger.getLogger(Node1DAOImp.class);

	@Override
	@Transactional(readOnly=true)
	public Node1 find(NodePK id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, id);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return n;
	}

	@Override
	@Transactional(readOnly = true)
	public Node1 findFromUserId(Long id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(
					new FindByCondition1<Node1>(id, "findNode1FromUserId"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return n;
	}

	@Override
	@Transactional(readOnly = true)
	public Node1 findFromSmileId(String id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().execute(
					new FindByCondition1<Node1>(id, "findFromSmileId"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return n;
	}

	@Override
	@Transactional
	public void persist(Node1 node) {
		try {
			getJpaTemplate().persist(node);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}		
	}

	@Override
	@Transactional
	public void update(Node1 node) {
		try {
			getJpaTemplate().merge(node);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}			
	}

	@Override
	@Transactional(readOnly=true)
	public Node1 findByHashCode(String hashCode) {
		Node1 node = null;
		try{
			node = getJpaTemplate().execute(new FindByCondition1<Node1>(hashCode, "findByHashcode"));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return node;
	}

	@Override
	@Transactional(readOnly=true)
	public Node1 find2(NodePK id) {
		Node1 n = null;
		try {
			n = getJpaTemplate().find(Node1.class, id);
		} catch (Exception e) {
		}
		return n;
	}

	@Override
	@SuppressWarnings("unchecked")	
	@Transactional(readOnly=true)
	public List<Long> findNonSpace(long lower, long upper) {
		List<Long> nonspace=null;
		try{
			nonspace =(List<Long>) getJpaTemplate().executeFind(new FindListByCondition2<Long>("findNonSpace",lower,upper));
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return nonspace;
	}

	@Override
	@Transactional(readOnly=true)
	public String findDisplayName(long pos) {
		String  displayName = null;
		try{
			displayName = getJpaTemplate().execute(new FindByCondition1<String>(pos,"findDisplayNameByPos"));
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return displayName;
	}
	
}
