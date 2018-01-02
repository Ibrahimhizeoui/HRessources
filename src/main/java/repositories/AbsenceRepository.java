package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public interface AbsenceRepository extends JpaRepository<Employee,Integer>{

}
