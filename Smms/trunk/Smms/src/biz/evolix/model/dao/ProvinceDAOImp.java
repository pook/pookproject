package biz.evolix.model.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Province;

@Repository
@Transactional
public class ProvinceDAOImp extends JpaDaoSupport implements ProvinceDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Province> findAll()throws DataAccessException {
		return (List<Province>)getJpaTemplate().findByNamedQuery("findAllProvince");
	}

}
