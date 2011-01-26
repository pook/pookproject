package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class MaxResultCon2<T> implements JpaCallback<List<T>> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery) ;
		q.setFirstResult(this.start);
		q.setMaxResults(this.max);
		q.setParameter(1,this.arg0);
		q.setParameter(2, this.arg1);
		return (List<T>)q.getResultList();
	}
	private Object arg0;
	private Object arg1;
	private int start;
	private int max;
	private String nameQuery;
	public MaxResultCon2(Object arg0, Object arg1, int start, int max,
			String nameQuery) {
		super();
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.start = start;
		this.max = max;
		this.nameQuery = nameQuery;
	}
	
}
