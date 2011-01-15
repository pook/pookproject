package biz.evolix.model.dao.callback;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class FindListByCon4<T> implements JpaCallback<List<T>>{

	@SuppressWarnings("unchecked")
	@Override
	public List<T> doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery(this.nameQuery);
		q.setParameter(1, arg0);
		q.setParameter(2, arg1);
		q.setParameter(3, arg2);
		q.setParameter(4, arg3);
		return (List<T>)q.getResultList();
	}
	private Object arg0,arg1,arg2,arg3;
	private String nameQuery;
	public FindListByCon4(Object arg0, Object arg1, Object arg2, Object arg3,
			String nameQuery) {
		super();
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.nameQuery = nameQuery;
	}
	
}
