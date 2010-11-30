package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class GenericSize<T> implements JpaCallback<T> {

	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createQuery("", clz);
		return null;
	}
	private String sqlQuery;
	private Class clz;
	public GenericSize(String sqlQuery, Class clz) {
		super();
		this.sqlQuery = sqlQuery;
		this.clz = clz;
	}
	
}
