package dao;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Absence;

public class AbsenceDaoTest {
	private static ConfigurableApplicationContext context;
	private static AbsenceDao absenceDao;
	private static Absence absence;
	
	@BeforeClass
	public static void beforeEachTest() {
		 context = new ClassPathXmlApplicationContext("Application-context.xml");
		 absenceDao = (AbsenceDao)context.getBean("absenceDao");
		 absence = (Absence)context.getBean("absence");
	}
	
	@Test
	public void testSave(){
		absence.setBeginAt(new Date());
		absence.setDescription("Web developer");
		absence.setType("permanant");
		absence.setEndAt(null);
		absenceDao.getAbsenceRepository().saveAndFlush(absence);
	}

}
