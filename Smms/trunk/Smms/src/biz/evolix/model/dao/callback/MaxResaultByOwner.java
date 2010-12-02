package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

import biz.evolix.model.Users;
import java.util.List;
public class MaxResaultByOwner <T> implements JpaCallback<List<T>> {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.sqlNameQuery);
		q.setParameter(1,this.user);
		q.setMaxResults(this.max);
		q.setFirstResult(this.start);
		return (List<T>)q.getResultList();
	}
	private Users user;
	private String sqlNameQuery;
	private Integer max;
	private Integer start;
	public MaxResaultByOwner(String sqlNameQuery,Users user,Integer start,Integer max) {
		super();
		this.user = user;this.sqlNameQuery=sqlNameQuery;
		this.start = start;
		this.max = max;		
	}
	
}
