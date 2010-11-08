package biz.evolix.model.dao;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Sku;
@Repository
@Transactional
public class SkuDAOImp extends JpaDaoSupport implements SkuDAO {

	
	@Transactional(readOnly=false)
	public void addItem(Sku p) {
		getJpaTemplate().persist(p);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true,propagation=Propagation.REQUIRES_NEW)
	public List<Sku> showAllItem() {
		return (List<Sku>)getJpaTemplate().find("select S from Sku s ");
	}	
	
	@Override
	@Transactional
	public void remove(Sku sku) {
		getJpaTemplate().remove(sku);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Sku find(long id) {		
		return getJpaTemplate().find(Sku.class,id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sku> find(int from, int to)throws NullPointerException {
		return getJpaTemplate().find("select K from Sku K where k.sid >?1 and k.sid <?2",from,to );
	}
	
	
	
}
