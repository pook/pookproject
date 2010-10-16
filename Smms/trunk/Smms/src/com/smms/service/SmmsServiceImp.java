package com.smms.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.smms.control.PersistenceName;
import com.smms.model.Account;
import com.smms.model.Users;

public class SmmsServiceImp implements SmmsService {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public SmmsServiceImp() {		
		emf = Persistence.createEntityManagerFactory(PersistenceName.PERSISTENCE_UNIT);
		em=emf.createEntityManager();
	}

	@Override
	public boolean authentication(String user, String passwd) {
		em.getTransaction().begin();
		Users usr=em.find(Users.class, user);
		Query accs = em.createQuery("select Object(a) from Account a "+
		"where a.acc_id=?1 ");//and a.acc_id < 16");
       List list = accs.getResultList();
		
        //
		em.getTransaction().commit();
		if(list.isEmpty())System.out.println("  &&&&&&&&&&&&&&&&&& "+list.size());
		return (usr!=null)?true:false;
	}

	@Override
	public List<Account> getTeam(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
