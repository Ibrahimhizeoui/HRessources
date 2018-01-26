package dao;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Activity;
import model.Employee;

public class ActivityDaoTest {
	
	private static ConfigurableApplicationContext context;
	private static ActivityDao activityDao;
	private static Activity activity;
	private static EmployeeDao employeeDao;
	private static Employee employee;
	
	@BeforeClass
	public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 activityDao = (ActivityDao)context.getBean("activitydao");
		 activity = (Activity)context.getBean("activity");
		 employeeDao = (EmployeeDao)context.getBean("employeedao");
		 employee = (Employee)context.getBean("employee");
	}
	@Ignore
	@Test
	public void testSave(){
		activity.setBeginAt(new Date());
		activity.setBudget(200);
		activity.setCreatedAt(new Date());
		activity.setEndAt(new Date());
		activity.setName("dinner");
		activity.setNotes("xx xx");
		activity.setType("private");
		activityDao.getActivityRepository().saveAndFlush(activity);
		assertThat(activityDao.getActivityRepository().saveAndFlush(activity),instanceOf(Activity.class));
	}
	@Ignore
	@Test
	public void testfind(){
		activity = activityDao.getActivityRepository().findOne(1);
		assertNotNull(activity);
		assertThat(activity = activityDao.getActivityRepository().findOne(1),instanceOf(Activity.class));
	}
	@Ignore
	@Test
	public void testUpdate(){
		activity = activityDao.getActivityRepository().findOne(1);
		activity.setBeginAt(new Date());
		activity.setBudget(2000);
		activity.setCreatedAt(new Date());
		activity.setEndAt(new Date());
		activity.setName("lunch");
		activity.setNotes("xx yy");
		activity.setType("public");
		activity = activityDao.getActivityRepository().saveAndFlush(activity);
		assertThat(activity,instanceOf(Activity.class));
	}
	
	@Test
	public void testManyToMany(){
		List<Activity> activities = activityDao.getActivityRepository().findAll();
		Employee e = employeeDao.getEmployeeRepository().findOne(3);
		e.setActivities(activities);
		employeeDao.getEmployeeRepository().save(e);
		e = employeeDao.getEmployeeRepository().findOne(3);
		assertEquals(2,e.getActivities().size());
		System.out.print(e.getActivities().size());
		
	}
}
