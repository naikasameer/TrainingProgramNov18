package com.mastek.training_app.jdbcapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeJDBCClient {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/mastek/training_app/jdbcapp/jdbc.xml");
		DataAccessObject<Employee> empDAO =
					(DataAccessObject<Employee>)ctx.getBean("empJDBCDAO");
		
		Employee emp = new Employee();
		emp.setEmpno(11988);
		emp.setProjectId(3323);
		emp.setProjectLocation("Mumbai");
		emp.setProjectName("Simple Application");
		
		//empDAO.add(emp);
	
		Employee empRemove = new Employee();
		empRemove.setEmpno(11988);
		empRemove.setProjectId(2323);
		
		//empDAO.remove(empRemove);
		
		for(Employee currentEmp : empDAO.list()) {
			System.out.println(currentEmp);
		}
		
		for(Employee currentEmp : empDAO.find(11988)) {
			System.out.println(currentEmp);
		}
	}

}
