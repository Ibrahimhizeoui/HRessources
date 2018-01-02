package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Activity;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activity,Integer>{

}
