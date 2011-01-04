package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class RemoveNull<T> implements JpaCallback<T>{

	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("removeAuthorities");
		q.executeUpdate();
		return (T)q;
	}
}
