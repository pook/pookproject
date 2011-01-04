package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class UpdateCon1<T> implements JpaCallback<T>{

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, arg0);
		q.executeUpdate();
		return (T)q;
	}
	private String nameQuery;
	private Object arg0;
	public UpdateCon1( Object arg0,String nameQuery) {
		super();
		this.nameQuery = nameQuery;
		this.arg0 = arg0;
	}	
}
