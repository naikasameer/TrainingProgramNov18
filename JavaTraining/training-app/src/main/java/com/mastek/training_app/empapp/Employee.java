package com.mastek.training_app.empapp;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Employee {
	
	int empno;
	String name;
	double salary;
	
	URL profileURL;
	
	List<String> skills;
	Map<String, String> currentProjects;	
 
	public Employee() { }

	public Employee(int empno, String name, double salary) {
		super();
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", profileURL=" + profileURL
				+ ", skills=" + skills + ", currentProjects=" + currentProjects + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public URL getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(URL profileURL) {
		this.profileURL = profileURL;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getCurrentProjects() {
		return currentProjects;
	}

	public void setCurrentProjects(Map<String, String> currentProjects) {
		this.currentProjects = currentProjects;
	}

	
	
}
