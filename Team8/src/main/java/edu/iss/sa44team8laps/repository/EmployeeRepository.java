package edu.iss.sa44team8laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.sa44team8laps.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
