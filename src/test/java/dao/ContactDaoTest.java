package dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Contact;
import model.Employee;

public class ContactDaoTest {

	private static ConfigurableApplicationContext context;
	private static ContactDao contactDao;
	private static Contact contact;
	private static Employee employee;
	
	@BeforeClass
	public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 contactDao = (ContactDao)context.getBean("contactdao");
		 contact = (Contact)context.getBean("contact");
		 employee = (Employee)context.getBean("employee");
		 }

	@Test
	public void testsave(){
		contact.setEmail("nn@fffffm");
		contact.setPhone("+46444666");
		employee.setId(1);
		contact.setEmployee(employee);
		contactDao.getContactRepository().saveAndFlush(contact);
		assertThat(contact,instanceOf(Contact.class));
		assertNotNull(contact);
	}
	@Ignore
	@Test
	public void testfind(){
		contact = contactDao.getContactRepository().findOne(6);
		assertThat(contact,instanceOf(Contact.class));
		assertNotNull(contact);	
	}
	@Ignore
	@Test
	public void testupdate(){
		contact = contactDao.getContactRepository().findOne(7);
		contact.setEmail("ib@dd.com");
		contact.setPhone("+4612315452");
		employee.setId(1);
		contact.setEmployee(employee);
		Contact c = contactDao.getContactRepository().saveAndFlush(contact);
		assertThat(c,instanceOf(Contact.class));
		assertNotNull(c);
		assertThat(c.getEmployee(),instanceOf(Employee.class));
		assertNotNull(c.getEmployee());
		System.out.println(c.getEmployee().toString());
	}
}
