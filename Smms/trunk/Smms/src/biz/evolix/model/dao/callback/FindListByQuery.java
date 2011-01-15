package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindListByQuery<T> implements JpaCallback <List<T>>{

	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createQuery(this.query);
		q.setFirstResult(this.start);
		q.setMaxResults(this.max);
		return (List<T>)q.getResultList();
	}
	private String query;
	public FindListByQuery(int start,int max,String query) {
		super();
		this.query = query;
		this.start = start;
		this.max = max;
	}
	private int start;
	private int max;

}
