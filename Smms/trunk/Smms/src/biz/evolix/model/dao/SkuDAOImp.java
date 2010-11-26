package biz.evolix.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import biz.evolix.model.Sku;
import biz.evolix.model.dao.callback.SkuMaxResult;

@Repository
@Transactional
public class SkuDAOImp extends JpaDaoSupport implements SkuDAO {

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void addItem(Sku p) {
		try {
			getJpaTemplate().persist(p);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Sku> showAllItem() {
		return (List<Sku>) getJpaTemplate().find("select S from Sku s ");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(long id) {
		try {
			Sku sku = getJpaTemplate().find(Sku.class, id);
			getJpaTemplate().remove(sku);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Sku find(long id) throws NullPointerException {
		return getJpaTemplate().find(Sku.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Sku> find(int from, int to) throws NullPointerException {
		return getJpaTemplate().find(
				"select K from Sku K where k.sid >?1 and k.sid <?2", from, to);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Sku> findLimit(int min, int maxResult)
			throws NullPointerException {
		List<Sku> skus = null;
		try {
			skus = getJpaTemplate()
					.executeFind(
							new SkuMaxResult<Sku>(min, maxResult,
									"Select K from Sku K"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return skus;
	}

	private static Logger log = Logger.getLogger(SkuDAOImp.class);
}
