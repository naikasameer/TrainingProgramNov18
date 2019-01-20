package com.mastek.training_app.hibernateapp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class PaymentDAO implements DataAccessObject<Payment>{

	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override // will be able to add all types of Payment[ChequePayment,CardPayment]
	public Payment add(Payment newEntity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(newEntity);
		session.getTransaction().commit();
		session.close();
		return newEntity;
	}
	

	@Override
	public List<Payment> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment getPaymentByType(Class cls,int key) {
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();

		// specific fetch for Payment Object using the class details
		Payment p =(Payment) session.get(cls,key);
		session.getTransaction().commit();
		session.close();
		return p;		
	}
	
	
	
	@Override
	public List<Payment> find(int key) {
		Session session =  getSessionFactory().openSession();
		session.beginTransaction();

		// generic fetch for Payment Object
		Payment p = session.get(Payment.class,key);
		session.getTransaction().commit();
		session.close();
		
		List<Payment> payments =  new ArrayList<>();
		payments.add(p);
		return payments;
	}

	@Override
	public Payment remove(Payment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment update(Payment e) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
