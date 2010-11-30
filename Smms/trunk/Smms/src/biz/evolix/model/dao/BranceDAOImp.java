package biz.evolix.model.dao;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Brance;

public class BranceDAOImp extends JpaDaoSupport implements BranceDAO {

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Brance> findAll() {
		return getJpaTemplate().findByNamedQuery("findAllBrance");
	}

}
