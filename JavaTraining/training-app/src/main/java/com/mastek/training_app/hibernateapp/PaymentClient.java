package com.mastek.training_app.hibernateapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastek.training_app.jdbcapp.DataAccessObject;

public class PaymentClient {

	public static void main(String[] args) {
		
		Payment p1 = new Payment();
		p1.setAmount(1000);
		
		ChequePayment chp =  new ChequePayment();
		chp.setAmount(9878);
		chp.setChequeNumber(3445232);
		chp.setBankName("HSBC");
		
		CardPayment ccp =  new CardPayment();
		ccp.setAmount(3000);
		ccp.setCardNumber(1234111144442223l);
		ccp.setCardType("Credit");

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
							"com/mastek/training_app/hibernateapp/hibernate.xml");
		
		PaymentDAO pDAO = (PaymentDAO) ctx.getBean("hibernatePaymentDAO");
		// save all three objects
		pDAO.add(p1);
		pDAO.add(chp);
		pDAO.add(ccp);
		
		
		System.out.println(pDAO.find(1).get(0));
		
		System.out.println(pDAO.find(2).get(0));
		System.out.println(pDAO.getPaymentByType(ChequePayment.class,2));
		
		System.out.println(pDAO.find(3).get(0));
		System.out.println(pDAO.getPaymentByType(CardPayment.class,3));
	}
}
