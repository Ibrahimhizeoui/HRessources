package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.PositionRepository;

public class PositionDao {
	
	@Autowired
	private PositionRepository positionRepository;

	public PositionRepository getPositionRepository() {
		return positionRepository;
	}
}
