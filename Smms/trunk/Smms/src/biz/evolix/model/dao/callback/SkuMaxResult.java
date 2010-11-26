package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

import biz.evolix.model.Sku;

public class SkuMaxResult<T> implements JpaCallback<List<T>> {

	@Override
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		  Query query = em.createQuery(sqlQuery);
	      query.setFirstResult(min);
	      query.setMaxResults(max);
	      @SuppressWarnings("unchecked")
		  List<T> results = query.getResultList();
	      return results;		
	}
	private int max;
	private int min;
	private String sqlQuery;
	public SkuMaxResult(int min, int max, String sqlQuery) {
		super();
		this.max = max;
		this.min = min;
		this.sqlQuery = sqlQuery;
	}
}
