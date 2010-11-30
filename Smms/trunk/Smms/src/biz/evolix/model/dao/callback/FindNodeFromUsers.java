package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

import biz.evolix.model.Users;

public class FindNodeFromUsers<T> implements JpaCallback<T> {

	@Override
	@SuppressWarnings("unchecked")	
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("findNode1FromUser");	
		q.setParameter(1, this.u);			
		return (T)q.getSingleResult();
	}
	private Users u;
	public FindNodeFromUsers(Users u) {
		super();
		this.u = u;
	}	
}
