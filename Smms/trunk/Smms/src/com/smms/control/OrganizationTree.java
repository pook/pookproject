package com.smms.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.smms.model.Account;

public class OrganizationTree {
	Account[] emt;
	final int root;

	public OrganizationTree(int root) {
		_OrganizationTree(root);
		this.root = root;
	}

	private void _OrganizationTree(int root) { // eg. (3)
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PersistenceName.PERSISTENCE_UNIT);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	 //   Query  accs = em.createQuery("SELECT A.ACC_ID,A.USERNAME FROM ACCOUNT A " +
	//			"WHERE A.ACC_ID>:0 AND A.ACC_ID < :16");
	//	Account acc = (Account) em.find(Account.class, root);
	 	em.getTransaction().commit();
	 	em.close();
	}

	private static int getLeft(final int current) {
		return current * 2;
	}

	private static int getRight(final int current) {
		return (current * 2) + 1;
	}

	private static int getParent(final int current) {
		return current / 2;
	}

}
