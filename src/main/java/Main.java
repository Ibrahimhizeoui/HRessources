import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDao;
import model.Employee;
import repositories.EmployeeRepository;

public class Main {

	@Autowired
	private static EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		//EmployeeRepository employeeRepository = (EmployeeRepository)context.getBean("employeeRepository");
		Employee employee = (Employee)context.getBean("employee");
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("employeedao");
		employee.setFirstName("ib3");
		employee.setLastName("hi3");
		employeeRepository.saveAndFlush(employee);
		

	}

}
