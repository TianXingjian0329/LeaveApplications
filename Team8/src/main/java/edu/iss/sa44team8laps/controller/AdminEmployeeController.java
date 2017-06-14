package edu.iss.sa44team8laps.controller;

import java.util.ArrayList;

import edu.iss.sa44team8laps.javabeans.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable String id, final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/admin/employeelist");
		Employee employee = e.findEmployeeById(Integer.valueOf(id));
		e.removeEmployee(employee);
//		String message = "The employee " + employee.getEmployeeId() + " was successfully deleted.";
//		redirectAttributes.addFlashAttribute("message", message);
		User user=u.findUserByEmpId(employee.getEmployeeId());
		u.removeUser(user);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newEmployeePage() {

		ModelAndView mav = new ModelAndView("employee-create");
		CreateEmployee createEmployee = new CreateEmployee();

		createEmployee.setEmpName("");
		createEmployee.setPassWord("");
		createEmployee.setRoleName("");
		createEmployee.setManagerName("");

		// Generating employeeid
		List<Employee> employeeList = e.findAllEmployees();
		Integer employeeId = ((employeeList.get(employeeList.size() - 1)).getEmployeeId()) + 1;
		createEmployee.setEmployeeId(employeeId);

		// Generating the list of possible managers
		ArrayList<String> managerList = new ArrayList<String>();
		for(Employee em : employeeList){
			int managerId=em.getManagerId();
			if(managerId!=0){
				User manager= u.findUserByEmpId(managerId);
				managerList.add(manager.getUserName());
			}		
		}
		mav.addObject("managerList", managerList);

		// Generating the list of possible roles
		ArrayList<Role> roleList = r.findAllRole();
		ArrayList<String> roleNameList = new ArrayList<String>();
		for (Role role : roleList) {
			roleNameList.add(role.getRoleName());
		}
		mav.addObject("roleNameList", roleNameList);
		mav.addObject(createEmployee);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewEmployee(@ModelAttribute CreateEmployee createEmployee,
			final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView();
		String message = "New employee " + createEmployee.getEmpName() + " was successfully created.";

		List<User> userList = u.findAllUsers();
		List<Employee> employeeList = e.findAllEmployees();
		User user = new User();
		Employee employee = new Employee();

		// create user
		user.setUserId((userList.get(userList.size() - 1)).getUserId() + 1);
		user.setUserName(createEmployee.getEmpName());
		user.setEmployeeId(createEmployee.getEmployeeId());
		user.setUserPassword(createEmployee.getPassWord());
		user.setRoleid((r.findRoleByName(createEmployee.getRoleName().trim())).getRoleId());
		u.createUser(user);

		// create employee
		employee.setEmployeeId(createEmployee.getEmployeeId());
		employee.setManagerId(u.findUserByName(createEmployee.getManagerName().trim()).getEmployeeId());
		employee.setId((employeeList.get(employeeList.size() - 1)).getId() + 1);
		e.createEmployee(employee); 
		
		mav.setViewName("redirect:/admin/employeelist");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}

