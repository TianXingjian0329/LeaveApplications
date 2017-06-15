package edu.iss.sa44team8laps.controller;

	import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
	import java.util.Date;

	import javax.servlet.http.HttpSession;
	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.propertyeditors.CustomDateEditor;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.WebDataBinder;
	import org.springframework.web.bind.annotation.InitBinder;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.sa44team8laps.javabeans.LeaveHistory;
import edu.iss.sa44team8laps.javabeans.employeeLeave;
import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.model.LeaveType;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.service.ApplicationService;
import edu.iss.sa44team8laps.service.LeaveTypeService;
import edu.iss.sa44team8laps.service.RoleService;



	@Controller
	@RequestMapping(value = "/employee")
	public class ApplicationController {
		@Autowired
		private ApplicationService appservice;	
		@Autowired
		private LeaveTypeService ltservice;
		@Autowired
		private RoleService rservice;
		/**
		 * COURSE CRUD OPERATIONS
		 * 
		 * @return
		 */

		@RequestMapping(value = "/history")
		public ModelAndView employeeLeaveHistory(HttpSession session) {
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			ModelAndView mav = new ModelAndView("login");
			if (us.getSessionId() != null) {
				mav = new ModelAndView("/staff-leave-history");
				ArrayList<Application> apps=appservice.findAppByUserId(us.getUser().getUserId());
				ArrayList<LeaveHistory> lhs=new ArrayList<LeaveHistory>();
				ArrayList<LeaveHistory> lhss=new ArrayList<LeaveHistory>();
				for(Application app:apps){
					LeaveHistory lh=new LeaveHistory();
					if(app.getLeaveDate().before(Calendar.getInstance().getTime())){
						lh.setApplicationId(app.getApplicationId());
						lh.setComment(app.getComment());
						lh.setDays(app.getLeavePeriod());
						lh.setLeaveType(ltservice.findById(app.getLeaveId()).getLeaveName());
						lh.setReason(app.getReason());
						lh.setStartDate(app.getLeaveDate());
						lh.setStatus(app.getStatus());
						lhs.add(lh);
					}
					else{
						lh.setApplicationId(app.getApplicationId());
						lh.setComment(app.getComment());
						lh.setDays(app.getLeavePeriod());
						lh.setLeaveType(ltservice.findById(app.getLeaveId()).getLeaveName());
						lh.setReason(app.getReason());
						lh.setStartDate(app.getLeaveDate());
						lh.setStatus(app.getStatus());
						lhss.add(lh);
					}
					
				}
				
				mav.addObject("history", lhs);
				mav.addObject("future", lhss);
				return mav;
			}
			return mav;

		}
		@RequestMapping(value = "/withdraw/{id}", method = RequestMethod.GET)
		public ModelAndView deleteleave(@PathVariable Integer id, final RedirectAttributes redirectAttributes
				)  {

			ModelAndView mav = new ModelAndView("redirect:/employee/history");
			Application application = appservice.findAppById(id);
			String message = "Leave " + application.getApplicationId() + " was successfully withdrawn.";
			application.setStatus("WITHDRAWN"); 
			appservice.editApp(application);
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		@RequestMapping(value = "/createleave", method = RequestMethod.GET)
		public ModelAndView newLeavePage1(HttpSession session) {
			ModelAndView mav = new ModelAndView("login");
			UserSession us=(UserSession)session.getAttribute("USERSESSION");
			if(us.getSessionId()!=null){
				mav = new ModelAndView("createleave");
				ArrayList<String> leavetypes=new ArrayList<String>();
				employeeLeave el=new employeeLeave();
				User user=us.getUser();
				for(LeaveType lt : ltservice.findLeaveTypesByRoleName(user.getRole().getRoleName())){
					
					leavetypes.add(lt.getLeaveName());	
				}
				
				
				ArrayList<Application> apps= appservice.findAllApplications();
				int appid= apps.get(apps.size()-1).getApplicationId()+1;
				mav.addObject("newleave", el);
				mav.addObject("leavetypes", leavetypes);
				mav.addObject("appid", appid);
			}
			
			return mav;
		}

		@RequestMapping(value = "/createleave", method = RequestMethod.POST)
		public ModelAndView createNewApplication(@ModelAttribute @Valid employeeLeave el, BindingResult result,
				final RedirectAttributes redirectAttributes, HttpSession session) {
			if (result.hasErrors())
				return new ModelAndView("createleave");
			ModelAndView mav = new ModelAndView();			
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
					
			String message = "New Application " + el.getApplicationId() + " was successfully created.";
			
			Application app=new Application();
			app.setApplicationId(el.getApplicationId());
			app.setLeaveDate(el.getLeaveDate());
			app.setLeaveId(ltservice.findByName(el.getLeavetype()).getLeaveId());
			app.setLeavePeriod(el.getLeavePeriod());
			app.setStatus("SUBMITTED");
			app.setUserId(us.getUser().getUserId());
			mav.setViewName("redirect:/employee/history");
			
			appservice.createApp(app);
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		@RequestMapping(value = "/Leave/edit/{id}", method = RequestMethod.GET)
		
		public ModelAndView editApplicationPage(@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("staff-Leave-edit");
		Application application = appservice.findAppById(id);
			mav.addObject("Application", application);
			return mav;
		}

		@RequestMapping(value = "/course/edit/{id}", method = RequestMethod.POST)
		public ModelAndView editCourse(@ModelAttribute @Valid Application application, BindingResult result, @PathVariable Integer id,
				final RedirectAttributes redirectAttributes, HttpSession session) {
			if (result.hasErrors())
				return new ModelAndView("staff-leave-edit");
			ModelAndView mav = new ModelAndView();
			System.out.println("DATES****" + application.getLeaveDate());
			String message = "New application " + application.getApplicationId() + " was successfully created.";
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			application.setUserId(us.getUser().getUserId());
			application.setStatus("Submitted");
			mav.setViewName("redirect:/staff/history");
			appservice.editApp(application );
			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}


	}
	
