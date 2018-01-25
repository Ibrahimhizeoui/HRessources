package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Absence;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Integer>{

}
