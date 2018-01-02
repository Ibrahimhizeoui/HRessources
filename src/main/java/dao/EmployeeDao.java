package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.EmployeeRepository;

public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}
}
