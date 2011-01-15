package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class GenericsizeByQuery<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createQuery(this.query);
		return (T)q.getSingleResult();
	}
	private String query;
	public GenericsizeByQuery(String query) {
		super();
		this.query = query;
	}	
}
