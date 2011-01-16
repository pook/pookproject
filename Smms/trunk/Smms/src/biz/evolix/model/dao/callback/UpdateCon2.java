package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class UpdateCon2<T> implements JpaCallback<T>{

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, arg0);
		q.setParameter(2, arg1);
		q.executeUpdate();
		return (T)q;
	}
	private String nameQuery;
	private Object arg0,arg1;
	public UpdateCon2( Object arg0, Object arg1,String nameQuery) {
		super();
		this.nameQuery = nameQuery;
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
	

}
