package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;
public class MaxResult<T> implements JpaCallback<List<T>> {

	@Override
	@SuppressWarnings("unchecked")
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		  Query query = em.createNamedQuery(nameQuery);
	      query.setFirstResult(min);
	      query.setMaxResults(max);	 	  
	      return  query.getResultList();		
	}
	private int max;
	private int min;
	private String nameQuery;
	public MaxResult(int min, int max, String nameQuery) {
		super();
		this.max = max;
		this.min = min;
		this.nameQuery = nameQuery;
	}
}
