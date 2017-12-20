package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Employee;


public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee){
		employeeRepository.save(employee);
		
	}
}
