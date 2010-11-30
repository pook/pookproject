package biz.evolix.model.dao.callback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.JpaCallback;

public class CheckDisplayName<T> implements JpaCallback<T> {

	@Override
	public T doInJpa(EntityManager em) throws PersistenceException {
		Query q = em.createNamedQuery("findDisplayName");
		q.setParameter(1, this.name);
		log.info(this.name);		
		return (T)q.getSingleResult();
	}
	private String name;
	public CheckDisplayName(String name) {
		super();
		this.name = name;
	}	
	private static Logger log = Logger.getLogger(CheckDisplayName.class);
}
