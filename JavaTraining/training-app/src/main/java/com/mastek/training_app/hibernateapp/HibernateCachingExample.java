package com.mastek.training_app.hibernateapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class HibernateCachingExample {

	static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"com/mastek/training_app/hibernateapp/hibernate.xml");
	
	public static void main(String[] args) throws Exception{
		printAccount(56);
		printAccount(55);
		printAccount(56);
		printAccount(56);
		
		Thread.sleep(122000); // pause the execution for <x> milliseconds
		
		printAccount(56);
		printAccount(56);
		printAccount(56);
		
	}
	
	public static void printAccount(int accountId) {
	
		DataAccessObject<Account> dao = (DataAccessObject<Account>)
					ctx.getBean("hibernateDAO");
		
		System.out.println(dao.find(accountId).get(0));

	}
	
}
