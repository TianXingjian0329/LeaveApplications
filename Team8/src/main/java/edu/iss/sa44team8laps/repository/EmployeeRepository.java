package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT u FROM Employee u WHERE u.ManagerId=:un")
	ArrayList<Employee> findEmpByManagerId(@Param("un") Integer eid);
}
