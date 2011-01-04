package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindByCondition2<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, this.arg0);
		q.setParameter(2, this.arg1);
		return (T)q.getSingleResult();
	}
	private Object arg0;
	private Object arg1;
	private String nameQuery;
	public FindByCondition2(Object arg0, Object arg1,String nameQuery) {
		super();
		this.arg0 = arg0;
		this.arg1 =arg1;
		this.nameQuery = nameQuery;
	}		
}
