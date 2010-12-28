package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindByCondition1<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, this.key);
		return (T)q.getSingleResult();
	}
	private String nameQuery;
	private Object key;
	public FindByCondition1( Object key,String nameQuery) {
		super();
		this.nameQuery = nameQuery;
		this.key = key;
	}
	
}
