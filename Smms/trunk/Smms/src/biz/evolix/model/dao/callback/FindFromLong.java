package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindFromLong<T> implements JpaCallback<T> {

	@Override
	@SuppressWarnings("unchecked")	
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, this.userId);
		return (T)q.getSingleResult();
	}
	private Long userId;
	private String nameQuery;
	public FindFromLong(Long userId,String nameQuery) {
		super();
		this.userId = userId;
		this.nameQuery = nameQuery;
	}
	
}
