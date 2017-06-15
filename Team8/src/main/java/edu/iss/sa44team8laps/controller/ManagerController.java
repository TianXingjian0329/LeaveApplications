package edu.iss.sa44team8laps.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.sa44team8laps.javabeans.ApplicationList;
import edu.iss.sa44team8laps.javabeans.Approve;
import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.LeaveType;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.service.ApplicationService;
import edu.iss.sa44team8laps.service.EmployeeService;
import edu.iss.sa44team8laps.service.LeaveTypeService;
import edu.iss.sa44team8laps.service.UserService;

@Controller
@RequestMapping(value="/manager")
public class ManagerController {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private UserService userService;

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LeaveTypeService leaveService;

	@RequestMapping(value = "/pending", method = RequestMethod.GET)
	public ModelAndView pendingApprovals(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		ModelAndView mav = new ModelAndView("view_app_approval");
		ArrayList<ApplicationList> applicationLlist = new ArrayList<ApplicationList>();
		if (us.getSessionId() != null) {
			User user = us.getUser();
			ArrayList<Employee> employeeList = employeeService.findEmployeesByManager(user.getUserId());
			
			for (Employee e : employeeList) {
				
				User u = userService.findUserByEmpId(e.getEmployeeId());
				
					ArrayList<Application> appList=applicationService.findAppByUserId(u.getUserId());
					
					for(Application a : appList){
						
						if((a.getStatus().equalsIgnoreCase("submitted")&&a.getLeaveDate().after(Calendar.getInstance().getTime()))){
							ApplicationList al=new ApplicationList();
							al.setAppId(a.getApplicationId());
							al.setUserName(u.getUserName());
							al.setDate(a.getLeaveDate());
							al.setPeriod(a.getLeavePeriod());
							al.setLeaveName(a.getLeaveType().getLeaveName());
							al.setReason(a.getReason());
							al.setStatus(a.getStatus());
							applicationLlist.add(al);
						}
					}
				
			}
			mav.addObject("pendingApproval", applicationLlist);
		}
		return mav;
	}
	
	@RequestMapping(value = "/application/history/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView subordnateHistory(@PathVariable Integer id)
	{
		Application app=applicationService.findAppById(id);
		
		ArrayList<ApplicationList> applicationList=new ArrayList<ApplicationList>();
		
		ArrayList<Application>  oldappList= 
				applicationService.listHistoryByUserIdBeforeTime(app.getUserId(), app.getLeaveDate());
		
			for(Application a:oldappList){
					ApplicationList al=new ApplicationList();
					al.setUserName(a.getUser().getUserName());
					al.setAppId(a.getApplicationId());
					al.setDate(a.getLeaveDate());
					al.setPeriod(a.getLeavePeriod());
					al.setLeaveName(a.getLeaveType().getLeaveName());
					al.setReason(a.getReason());
					al.setStatus(a.getStatus());
					al.setComment(a.getComment());
					applicationList.add(al);
			}
		ModelAndView mav = new ModelAndView("manager-subordinate-history");
		mav.addObject( "subordinateHistory", applicationList);
		return mav;
	}
	
	@RequestMapping(value = "/application/editedhistory/{id}", method = RequestMethod.GET)
	public ModelAndView subordnateEditedHistory(HttpSession session){
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		ModelAndView mav = new ModelAndView("subordnate-edited-history");
		ArrayList<ApplicationList> applicationLlist = new ArrayList<ApplicationList>();
		if (us.getSessionId() != null) {
			User user = us.getUser();
			ArrayList<Employee> employeeList = employeeService.findEmployeesByManager(user.getUserId());
			
			for (Employee e : employeeList) {
				
				User u = userService.findUserByEmpId(e.getEmployeeId());
				
					ArrayList<Application> appList=applicationService.findAppByUserId(u.getUserId());
					
					for(Application a : appList){
						ApplicationList al=new ApplicationList();
						if(!(a.getStatus().equalsIgnoreCase("submitted"))){
							al.setAppId(a.getApplicationId());
							al.setUserName(u.getUserName());
							al.setDate(a.getLeaveDate());
							al.setPeriod(a.getLeavePeriod());
							al.setLeaveName(a.getLeaveType().getLeaveName());
							al.setReason(a.getReason());
							al.setStatus(a.getStatus());
							al.setComment(a.getComment());
							applicationLlist.add(al);
						}
					}
				
			}
			mav.addObject("editedApproval", applicationLlist);
		}
		return mav;
	}
	
	@RequestMapping(value = "/application/display/{id}", method = RequestMethod.GET)
	public ModelAndView displayAppToUpdate(@PathVariable Integer id) {
		
		Application app = applicationService.findAppById(id);
		
		ModelAndView mav = new ModelAndView("manager-app-detail", "application", app);
		
		mav.addObject("approve",new Approve());
		return mav;
	}
	
	@RequestMapping(value = "/application/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrReject(@ModelAttribute("approve") Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("manager-app-detail");
		
		Application app = applicationService.findAppById(id);
		
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		app.setStatus(approve.getDecision());
		app.setComment(approve.getComment());
		applicationService.editApp(app);
		ModelAndView mav = new ModelAndView("redirect:/manager/pending");
		String message = "Application was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
