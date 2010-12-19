package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class CheckDisplayName<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("findDisplayName");
		q.setParameter(1, this.name);				
		return (T)q.getSingleResult();
	}
	private String name;
	public CheckDisplayName(String name) {
		super();
		this.name = name;
	}
	
}
