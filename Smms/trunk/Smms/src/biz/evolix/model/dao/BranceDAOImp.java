package biz.evolix.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Brance;
import biz.evolix.model.Province;
import biz.evolix.model.dao.callback.FindAll;
import biz.evolix.model.dao.callback.MaxResult;

public class BranceDAOImp extends JpaDaoSupport implements BranceDAO {

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Brance> findAll() {
		return getJpaTemplate().findByNamedQuery("findAllBrance");
	}

	@Override
	@Transactional(readOnly=false)
	public boolean insert(Brance b) {
		try{
			getJpaTemplate().persist(b);
			return true;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Brance b,String pid) {
		try{
			getJpaTemplate().find(Province.class, pid);
			getJpaTemplate().merge(b);
			return true;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}		
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Brance b) {
		try{			
			getJpaTemplate().remove(b);
			return true;
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			return false;
		}		
	}


	@Override
	@Transactional(readOnly=true)
	public Long size() {		
		return getJpaTemplate().execute(new FindAll<Long>("branceSize"));
	}
	private static Logger log = Logger.getLogger(BranceDAOImp.class);
	@Override
	@Transactional(readOnly=true)
	public Province find(String id) {		
		return getJpaTemplate().find(Province.class, id);
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Brance> find(int from, long max) {
		return getJpaTemplate().executeFind(new MaxResult<Brance>(from,(int) max, "findAllBrance"));
	}

	@Override
	@Transactional(readOnly=true)
	public Brance find(Integer id) {		
		return getJpaTemplate().find(Brance.class, id);
	}
}
