package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class GenericSizeByCause<T,E> implements JpaCallback<T> {

	
	@Override
	@SuppressWarnings("unchecked")
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.sqlNameQuery);
		q.setParameter(1, this.c);
		return (T)q.getSingleResult();
	}
	public GenericSizeByCause(String sqlNameQuery,E c) {
		super();
		this.sqlNameQuery = sqlNameQuery;	
		this.c = c;
	}
	private String sqlNameQuery;
	private E c;
}
