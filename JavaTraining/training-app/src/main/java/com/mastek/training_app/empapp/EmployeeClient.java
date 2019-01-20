package com.mastek.training_app.empapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/empapp/employees.xml");
		
		System.out.println(ctx.getBean("defaultEmployee"));
		
		System.out.println(ctx.getBean("developerEmployee"));
	}
}
