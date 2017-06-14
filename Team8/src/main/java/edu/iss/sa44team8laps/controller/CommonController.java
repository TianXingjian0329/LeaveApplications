package edu.iss.sa44team8laps.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.service.EmployeeService;
import edu.iss.sa44team8laps.service.UserService;


@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	private UserService uService;
	@Autowired
	private EmployeeService eService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "login";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (String.valueOf(user.getUserId()) != null && String.valueOf(user.getUserPassword()) != null) {
			User u = uService.authenticate(user.getUserName(), user.getUserPassword());			
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			if(u.getEmployeeId()==0){
				us.setType("admin");
				mav=new ModelAndView("redirect:/admin/employeelist");
			}
			else{
				int empId=u.getEmployeeId();
				boolean isManager=false;					
				ArrayList<Employee> elist=eService.findAllEmployees();
				for(int i=0;i<elist.size();i++){
					if(elist.get(i).getManagerId()==empId){
						isManager=true;
					}
				}
				if(isManager==true){
					us.setType("manager");
					mav =new ModelAndView("redirect:/manager");
				}
				else{
					us.setType("employee");
					mav=new ModelAndView("redirect:/employee/history");
				}				
			}
			
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}
}
