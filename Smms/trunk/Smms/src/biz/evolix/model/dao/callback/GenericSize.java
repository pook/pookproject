package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class GenericSize<T> implements JpaCallback<T> {
	
	@Override
	@SuppressWarnings("unchecked")	
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.sqlNameQuery);
		return (T)q.getSingleResult();
	}
	private String sqlNameQuery;
	
	public GenericSize(String sqlNameQuery) {
		super();
		this.sqlNameQuery = sqlNameQuery;		
	}		
}