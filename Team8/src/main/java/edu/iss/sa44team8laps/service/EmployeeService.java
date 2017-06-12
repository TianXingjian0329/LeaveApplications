package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import edu.iss.sa44team8laps.model.Employee;


public interface EmployeeService {
	ArrayList<Employee> findEmployeesByManager(int mid);

	Employee findEmployeeById(int eid);

	ArrayList<Employee> findAllEmployees();

	Employee findEmployeeByName(String ename);

	Employee createEmployee(Employee emp);

	Employee changeEmployee(Employee emp);

	void removeEmployee(Employee emp);
	
	ArrayList<Employee> findSubordinates(int mid);
	
}
