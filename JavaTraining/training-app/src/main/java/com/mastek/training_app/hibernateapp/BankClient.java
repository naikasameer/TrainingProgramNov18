package com.mastek.training_app.hibernateapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class BankClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		Account a1 = new Account(); // One Account can have many Transactions
		a1.setAccountType("Savings");
		a1.setBalance(2122);
		
		Account a2 = new Account(); 
		a2.setAccountType("Current");
		a2.setBalance(2134);

		Customer c1 = new Customer();
		c1.setName("C1");
		
		Customer c2 = new Customer();
		c2.setName("C2");
		
		// add owners to account
		a1.getOwners().add(c1);
		a2.getOwners().add(c2);
		a1.getOwners().add(c2);
		
		
		for (int i = 1; i <=5; i++) {
			Transaction tx = new Transaction();
			tx.setTransactionType("Credit");
			tx.setAmount(i*100);
			
			//assign Account to each transaction
			tx.setAccount(a1); 
			//associate Transaction with respective Account
			a1.getTransactions().add(tx);
		}
		
		DataAccessObject<Account> dao = (DataAccessObject<Account>)
				ctx.getBean("hibernateDAO");
		//dao.add(a1); // insert account object with customers,registrations and Transaction
		//dao.add(a2);
		
		
		Account acc = dao.find(13).get(0);
		System.out.println(acc);
		//in case of lazy, since the session is closed: Lazy Initialization Exception
		System.out.println("Count: "+acc.getTransactions().size());
		System.out.println(acc.getTransactions());
		
		System.out.println("Count: "+acc.getOwners().size());
		System.out.println(acc.getOwners());
		
		for (Transaction tx : acc.getTransactions()) {
			// Fetch Account details using Transaction Object
			System.out.println(tx.getAccount().getAccountType());
		}
		
		
	}
}