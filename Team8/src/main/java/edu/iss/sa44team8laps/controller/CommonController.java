package edu.iss.sa44team8laps.controller;

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
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (String.valueOf(user.getUserId()) != null && String.valueOf(user.getUserPassword()) != null) {
			User u = uService.authenticate(user.getUserId(), user.getUserPassword());
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			int empId=u.getEmployeeId();
			Employee emp=eService.findEmployeeById(empId);
			if(String.valueOf(emp.getManagerId())!=null){
				mav=new ModelAndView("redirect:/manager");
			}
			else{
				mav = new ModelAndView("redirect:/employee");
			}
			
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}
}
