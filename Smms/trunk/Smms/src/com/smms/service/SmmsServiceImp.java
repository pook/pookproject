package com.smms.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smms.model.Users;

public class SmmsServiceImp implements SmmsService {
	private EntityManager em;
	private EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT="SmmsPU";
	public SmmsServiceImp() {
		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		em=emf.createEntityManager();
	}

	@Override
	public boolean authentication(String user, String passwd) {
		em.getTransaction().begin();
		Users usr=em.find(Users.class, user);
		em.getTransaction().commit();
		return (usr!=null)?true:false;
	}

}
