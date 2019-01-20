package com.mastek.training_app.hibernateapp.criterion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.hibernateapp.Account;

public class CriteriaQueryClient {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		SessionFactory factory =  (SessionFactory) ctx.getBean("sessionFactory");
		Session currentSession =  factory.getCurrentSession();
		
		currentSession.beginTransaction();		
		
		Criteria critAccount = currentSession.createCriteria(Account.class);
		critAccount.setMaxResults(30);

		// select where type is DEMAT
		critAccount.add(Restrictions.eq("accountType","DEMAT"));
		critAccount.add(Restrictions.between("balance", 70000.0, 80000.0));
		
		List<Account> accs = (List<Account>) critAccount.list();
		
		for (Account acc : accs) {
			System.out.println(acc);
			//System.out.println("Transaction Count:"+acc.getTransactions().size());	
		}										  // if getCurrentSession()
		
		Criteria critStats = currentSession.createCriteria(Account.class);
		ProjectionList plList = Projections.projectionList();
		
		plList.add(Projections.sum("balance"));
		plList.add(Projections.min("balance"));
		plList.add(Projections.max("balance"));
		plList.add(Projections.count("balance"));
		plList.add(Projections.avg("balance"));
		
		critStats.setProjection(plList);
		
		Object[] stats = (Object[])critStats.list().get(0);
		
		System.out.println("Sum: "+stats[0]+" Min: "+stats[1]+" Max:"+stats[2]
				+" Count: "+stats[3]+" Avg: "+stats[4]);
		
		currentSession.getTransaction().commit();// auto close the session
	}
}








