package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class LoadUser <T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q  = em.createNamedQuery(this.nameQuery);
		q.setParameter(1,this.smileId);
		return (T)q.getSingleResult();
	}
	private String smileId;
	private String nameQuery;
	public LoadUser(String smileId, String nameQuery) {
		super();
		this.smileId = smileId;
		this.nameQuery = nameQuery;
	} 	
}
