package com.mastek.training_app.hibernateapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class AccountClient {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		DataAccessObject<Account> dao = (DataAccessObject<Account>)
					ctx.getBean("hibernateDAO");
		
		Account a = new Account();
		a.setAccountType("Savings");
		a.setBalance(2333);
		
	/*	dao.add(a);
		
		System.out.println(dao.find(1));
		
		Account adb = dao.find(1).get(0);
		adb.setBalance(adb.getBalance()+122);
		
		adb = dao.update(adb);
		
		Account adelete = dao.find(5).get(0);
		dao.remove(adelete);		
		*/
		
		populateAccounts(10000);
		
	}
	
	public static void populateAccounts(int count) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/hibernateapp/hibernate.xml");
	
		DataAccessObject<Account> dao = (DataAccessObject<Account>)
						ctx.getBean("hibernateDAO");
		
		for (int i = 1; i <=count; i++) {
			Account a = new Account();
			a.setAccountType((i%2==0)?"SAVINGS":(i%5==0)?"DEMAT":"CURRENT");
			a.setBalance(i*100);
			
			dao.add(a);
		}
	}
}





