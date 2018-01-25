package dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Address;
import model.Contact;
import model.Employee;
import model.Position;

public class EmployeeDaoTest {

	private static ConfigurableApplicationContext context;
	private static EmployeeDao employeeDao;
	private static Employee employee;
	private static Address address;
	private static Position position;
	
	
	 @BeforeClass
	 public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 employeeDao = (EmployeeDao)context.getBean("employeedao");
		 employee = (Employee)context.getBean("employee");
		 address = (Address)context.getBean("address");
		 position = (Position)context.getBean("position");
	    }
	@Ignore
	@Test
	public void testSave(){
		employee.setFirstName("vvv");
		employee.setLastName("vvvv");
		employee.setCreated_at(new Date());
		employeeDao.getEmployeeRepository().saveAndFlush(employee);
		assertThat(employeeDao.getEmployeeRepository().saveAndFlush(employee),instanceOf(Employee.class));
	}
	
	@Test
	public void testfind(){
		employee = employeeDao.getEmployeeRepository().findOne(1);
		assertThat(employee.getAddress() ,instanceOf(Address.class));
		assertNotNull(employee.getAddress());
		
		assertThat(employee.getContact() ,instanceOf(Contact.class));
		assertNotNull(employee.getContact());
		
		System.out.println(employee.getPosition().toString());
		System.out.println(employee.getContact().toString());
	}
	@Ignore
	@Test
	public void testUpdate(){
		employee = employeeDao.getEmployeeRepository().findOne(1);
		employee.setFirstName("gga");
		address.setId(1);
		employee.setAddress(address);
		employee = employeeDao.getEmployeeRepository().saveAndFlush(employee);
		assertEquals("gga",employee.getFirstName());
	}
	@Ignore
	@Test
	public void testSetPosition(){
		employee = employeeDao.getEmployeeRepository().findOne(3);
		position.setId(1);
		employee.setPosition(position);
		employeeDao.getEmployeeRepository().saveAndFlush(employee);
	}
	
}
