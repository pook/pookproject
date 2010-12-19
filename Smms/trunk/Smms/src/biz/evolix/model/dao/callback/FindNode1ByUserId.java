package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindNode1ByUserId<T> implements JpaCallback<T> {

	@Override
	@SuppressWarnings("unchecked")	
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("findNode1FromUserId");
		q.setParameter(1, this.userId);
		return (T)q.getSingleResult();
	}
	private String userId;
	public FindNode1ByUserId(String userId) {
		super();
		this.userId = userId;
	}
	
}
