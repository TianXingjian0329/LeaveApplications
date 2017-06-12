package edu.iss.sa44team8laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.repository.EmployeeRepository;
import edu.iss.sa44team8laps.repository.UserRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeRepository empRepository;
	@Resource 
	private UserRepository userRepository;
	@Override
	@Transactional
	public ArrayList<Employee> findEmployeesByManager(int mid) {
		// TODO Auto-generated method stub
		return empRepository.findEmpByManagerId(mid);
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return empRepository.findOne(eid);
	}

	@Override
	@Transactional
	public ArrayList<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return (ArrayList<Employee>)empRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployeeByName(String ename) {
		// TODO Auto-generated method stub
		User user=userRepository.findUserByName(ename);
		return empRepository.findOne(user.getEmployeeId());
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepository.saveAndFlush(emp);
	}

	@Override
	@Transactional
	public Employee changeEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepository.saveAndFlush(emp);
	}

	@Override
	@Transactional
	public ArrayList<Employee> findSubordinates(int mid) {
		// TODO Auto-generated method stub
		
		return empRepository.findEmpByManagerId(mid);
	}

	@Override
	public void removeEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empRepository.delete(emp);
	}

}
