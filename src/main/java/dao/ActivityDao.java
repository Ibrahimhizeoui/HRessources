package dao;

import org.springframework.beans.factory.annotation.Autowired;

import repositories.ActivityRepository;

public class ActivityDao {

	@Autowired
	private ActivityRepository activityRepository;

	public ActivityRepository getActivityRepository() {
		return activityRepository;
	}
}
