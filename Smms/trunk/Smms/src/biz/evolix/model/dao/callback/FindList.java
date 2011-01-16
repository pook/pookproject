package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindList<T> implements JpaCallback<List<T>> {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);		
		return (List<T>)q.getResultList();
	}
	private String nameQuery;
	public FindList(String nameQuery) {
		super();
		this.nameQuery = nameQuery;
	}
	
}
