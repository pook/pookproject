package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindFormString<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, this.key);
		return (T)q.getSingleResult();
	}
	private String nameQuery;
	private String key;
	public FindFormString( String key,String nameQuery) {
		super();
		this.nameQuery = nameQuery;
		this.key = key;
	}
	
}
