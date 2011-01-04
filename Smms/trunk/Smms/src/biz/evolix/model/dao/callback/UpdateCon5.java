package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class UpdateCon5<T>implements JpaCallback<T> {

	@Override
	@SuppressWarnings("unchecked")
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, arg0);
		q.setParameter(2, arg1);
		q.setParameter(3, arg2);
		q.setParameter(4, arg3);
		q.setParameter(5, arg4);
		q.executeUpdate();
		return (T)q;
	}
	private Object arg0,arg1,arg2,arg3,arg4;
	private String nameQuery;
	public UpdateCon5(Object arg0, Object arg1, Object arg2, Object arg3,
			Object arg4, String nameQuery) {
		super();
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
		this.nameQuery = nameQuery;
	}	
} 
