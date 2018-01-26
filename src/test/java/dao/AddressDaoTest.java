package dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Address;

public class AddressDaoTest {

	private static ConfigurableApplicationContext context;
	private static AddressDao addressDao;
	private static Address address;
	@BeforeClass
	public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 addressDao = (AddressDao)context.getBean("addressdao");
		 address = (Address)context.getBean("address");
		 }
	
	@Test
	public void testAdd(){
		address.setCareof("Cc");
		address.setCity("Strock");
		address.setCountry("SE");
		address.setStreet_address("cc");
		address.setUse_careof_as_attention(true);
		address.setZipcode("12255");
		address = addressDao.getAddressRepository().saveAndFlush(address);
		assertThat(address,instanceOf(Address.class));
		assertNotNull(address);		
	}
}
