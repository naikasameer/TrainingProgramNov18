package com.mastek.training_app.jdbcapp;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EmployeeJDBCDAO implements DataAccessObject<Employee>{

	// maps each record fetched from ResultSet to a Java Object
	RowMapper<Employee> empMapper= (rs,index) ->{
		Employee emp  = new Employee();
		
		emp.setEmpno(rs.getInt("empno"));
		emp.setProjectId(rs.getInt("projectid"));
		emp.setProjectName(rs.getString("name"));
		emp.setProjectLocation(rs.getString("location"));
		
		return emp;
	};
	
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Employee add(Employee newEmp) {
		int result = getTemplate().update(
		"insert into employee_projects (empno,projectid,name,location) values(?,?,?,?)",
			newEmp.getEmpno(),newEmp.getProjectId(),
			newEmp.getProjectName(),newEmp.getProjectLocation());
		
		System.out.println(result+ "Employee Inserted "+newEmp);
		
		return newEmp;
	}

	public List<Employee> list() {
		return getTemplate().query("select * from employee_projects", empMapper);
	}

	public List<Employee> find(int empno) {
		return getTemplate().query(
				"select * from employee_projects where empno=?",
				empMapper,empno);
	}

	public Employee remove(Employee e) {
		int result = getTemplate().update(
				"delete from employee_projects where empno=? and projectid=?", 
				e.getEmpno(),e.getProjectId());
		System.out.println(result +" Employee REmoved "+e);
		return e;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	
}




