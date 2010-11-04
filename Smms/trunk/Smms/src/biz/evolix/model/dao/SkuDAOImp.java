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
	
}
