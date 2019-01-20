package com.mastek.training_app.hibernateapp.hqlexamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.hibernateapp.Account;

public class HQLQueryClient {

	public static void main(String[] args) {
		
		String hql_SelectALL= "from Account";
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		SessionFactory factory =  (SessionFactory) ctx.getBean("sessionFactory");
									// openSession(): open the session, allows multiple
									//	transactions, session has be closed using 
									//	session.close()
									// getCurrentSession(): only one transaction
									// is allowed , closes session automatically
									//  on transaction commit
		Session currentSession =  factory.getCurrentSession();
		
		currentSession.beginTransaction();		
		
		Query<Account> qryAccount = currentSession.createQuery(hql_SelectALL);
		qryAccount.setFirstResult(60);// the index to start fetching records
		qryAccount.setMaxResults(60); // count of records for each page Fetch

		for (Account acc : qryAccount.list()) {
			System.out.println(acc);
			//System.out.println("Transaction Count:"+acc.getTransactions().size());	
		}										  // if getCurrentSession()
		currentSession.getTransaction().commit();// auto close the session
	}
}








