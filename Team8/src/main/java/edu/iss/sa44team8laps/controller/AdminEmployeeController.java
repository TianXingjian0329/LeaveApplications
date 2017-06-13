package edu.iss.sa44team8laps.controller;

import java.util.ArrayList;
import edu.iss.sa44team8laps.javabeans.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.Role;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.service.EmployeeService;
import edu.iss.sa44team8laps.service.RoleService;
import edu.iss.sa44team8laps.service.UserService;

@Controller
@RequestMapping(value="/admin")
public class AdminEmployeeController {
	
	@Autowired
	private EmployeeService e;
	@Autowired
	private RoleService r;
	@Autowired
	private UserService u;

	@RequestMapping(value="/employeelist", method = RequestMethod.GET)
	public ModelAndView employeeListPage() {
		ModelAndView mav = new ModelAndView("employee-list");
		List<Employee> employeeList = e.findAllEmployees();
		List<empList> empList = new ArrayList<empList>();
		
		for (Employee employee : employeeList)
		{	empList emp=new empList();
			if(employee.getEmployeeId()!=0){
				User user = u.findUserByEmpId(employee.getEmployeeId());	
				User manager = u.findUserByEmpId(employee.getManagerId());
				emp.setEmpId(employee.getEmployeeId());
				emp.setEmpName(user.getUserName());
				emp.setManagerName(manager.getUserName());
				emp.setRoleName(r.findRoleById(user.getRoleid()).getRoleName());
				empList.add(emp);
			}
			
		}
		mav.addObject("employeeList", empList);
		return mav;
	}

}

