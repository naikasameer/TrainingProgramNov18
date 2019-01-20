package com.mastek.training_app.hibernateapp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class HibernateAccountDAO implements DataAccessObject<Account>{

	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Account add(Account newEntity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(newEntity);// INSERT the object in DB
		session.getTransaction().commit();
		session.close();
		return newEntity;
	}

	@Override
	public List<Account> find(int key) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Account acc = session.get(Account.class, key); // Select
		session.getTransaction().commit();
		// Fetches all the transaction lazily only when requested 
		// in case the session is closed and we fetch Transaction,
		// LazyInitializationException
		//System.out.println("Count: "+acc.getTransactions().size());
		
		session.close();
		
		List<Account> list =  new ArrayList<>();
		list.add(acc);
		return list;
	}


	@Override
	public List<Account> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account remove(Account e) {
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		return e;
	}

	@Override
	public Account update(Account e) {
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(e);
		session.getTransaction().commit();
		session.close();
		return e;
	}
	
	

}
