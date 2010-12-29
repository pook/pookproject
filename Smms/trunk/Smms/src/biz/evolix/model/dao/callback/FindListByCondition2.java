package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindListByCondition2<T> implements JpaCallback<List<T>> {

	@Override
	@SuppressWarnings("unchecked")	
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, arg0);
		q.setParameter(2, arg1);		
		return (List<T>)q.getResultList();
	}
	private String nameQuery;
	private Object arg0;
	private Object arg1;
	public FindListByCondition2(String nameQuery, Object arg0, Object arg1) {
		super();
		this.nameQuery = nameQuery;
		this.arg0 = arg0;
		this.arg1 = arg1;	
	}
}
