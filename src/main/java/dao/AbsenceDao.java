package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.AbsenceRepository;

public class AbsenceDao {

	@Autowired
	private AbsenceRepository absenceRepository;

	public AbsenceRepository getAbsenceRepository() {
		return absenceRepository;
	}	
}
