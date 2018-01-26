package dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import model.Position;

public class PositionDaoTest {
	private static ConfigurableApplicationContext context;
	private static PositionDao positionDao;
	private static Position position;
	private static Employee employee;
	@BeforeClass
	 public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 positionDao = (PositionDao)context.getBean("positiondao");
		 position = (Position)context.getBean("position"); 
		 employee = (Employee)context.getBean("employee");
		 
	    }
	@Ignore
	@Test
	public void testSave(){
		position.setName("web designer");
		position.setBeginAt(new Date());
		position.setDescription("xxx");
		position.setEnabled(false);
		position.setEndAt(null);
		position.setCreatedAt(new Date());
		position = positionDao.getPositionRepository().saveAndFlush(position);
		assertThat(position,instanceOf(Position.class));
		assertNotNull(position);	
	}
	@Ignore
	@Test
	public void find(){
		position = positionDao.getPositionRepository().findOne(1);
		assertThat(position,instanceOf(Position.class));
		assertNotNull(position);
	}
	@Ignore
	@Test
	public void findAll(){
		List<Position> lp = positionDao.getPositionRepository().findAll();
		assertNotNull(lp);
	}
	@Test
	public void getEmployee(){
		position = positionDao.getPositionRepository().findOne(1);
		assertNotNull(position.getEmployees());	
		for(Employee e : position.getEmployees()){
			System.out.println(e);
		}
	}

}
