package com.mastek.training_app.empapp;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScreenClient {

	public static void main(String[] args) {
		/*ConsoleWelcomeScreen cws = new ConsoleWelcomeScreen();
		cws.setMessage("Welcome to SPring Application");

		cws.showScreen();
		
		ConsoleWelcomeScreen cws1 = new ConsoleWelcomeScreen();
		cws1.setMessage("Welcome to Employee Application");

		cws1.showScreen();*/
		
		// using Spring ApplicationContext
		
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext(
						"com/mastek/training_app/empapp/beans.xml");
		
		WelcomeScreen scr  = (WelcomeScreen) ctx.getBean("simpleScreen");
		scr.showScreen();
		
		WelcomeScreen scr1  = (WelcomeScreen) ctx.getBean("simpleScreen");
		scr1.showScreen();
		
		WelcomeScreen scr2  = (WelcomeScreen) ctx.getBean("simpleScreen");
		scr2.showScreen();
		
		ctx.close();
		
	}
}













