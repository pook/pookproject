package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.orm.jpa.JpaCallback;

public class CheckPasswdCB<T> implements JpaCallback<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("ckpasswd");
		q.setParameter(1, this.uid);
		q.setParameter(2, this.pw);
		return (T)q.getSingleResult();
	}
	private String uid;
	private String pw;
	public CheckPasswdCB(String uid, String pw) {
		super();
		this.uid = uid;
		this.pw = pw;
	}		
}
