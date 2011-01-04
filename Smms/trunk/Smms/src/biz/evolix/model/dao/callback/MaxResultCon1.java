package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class MaxResultCon1<T> implements JpaCallback<List<T>> {

	@Override
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery) ;
		q.setFirstResult(this.start);
		q.setMaxResults(this.max);
		q.setParameter(1,this.arg0);
		return null;
	}
	private Object arg0;
	private int start;
	private int max;
	private String nameQuery;
	public MaxResultCon1(Object arg0, int start, int max, String nameQuery) {
		super();
		this.arg0 = arg0;
		this.start = start;
		this.max = max;
		this.nameQuery = nameQuery;
	}
	
}
