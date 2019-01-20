package com.mastek.training_app.hibernateapp.hqlexamples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.hibernateapp.Account;

public class HQLNamedQueryClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		SessionFactory factory =  (SessionFactory) ctx.getBean("sessionFactory");
		Session currentSession =  factory.getCurrentSession();
		
		currentSession.beginTransaction();		
		
		//Query<Account> qryAccount = currentSession.getNamedQuery("fetchAllAccounts");
		Query<Account> qryAccount = currentSession.getNamedQuery(
											"fetchAccountsByBalance");
		// set the parameter values
		qryAccount.setParameter("min",5000.0);//qryAccount.setDouble("min", 5000.0);
		qryAccount.setParameter("max", 50000.0);
		
	//	Query<Account> qryAccount = currentSession.getNamedQuery(
	//												"fetchAccountsByAccountType");
	//	qryAccount.setParameter("type", "DEMAT");
		
		qryAccount.setFirstResult(0);// the index to start fetching records
		qryAccount.setMaxResults(30); // count of records for each page Fetch
		qryAccount.setCacheable(true); // execute query for fetching first records
			

		System.out.println(qryAccount.list()); // sql query will execute
		System.out.println(qryAccount.list()); // fetch the data from cache
		
		for (Account acc : qryAccount.list()) {//fetch the data from cache
			System.out.println(acc);
			//System.out.println("Transaction Count:"+acc.getTransactions().size());	
		}										  // if getCurrentSession()
				
		Query qryStats = currentSession.getNamedQuery("fetchAccountBalanceStats");
		System.out.println(qryStats.list());
		
		Object[] stats = (Object[])qryStats.list().get(0); // get First Object[]
		for(Object stat : stats) { //print statistics from the object []
			System.out.println(stat);
		}
		
		System.out.println("Max: "+stats[0]+" Min: "+stats[1]+" Sum: "+stats[2]
					+" Avg: "+stats[3]);
		
		currentSession.getTransaction().commit();// auto close the session
	}
}








