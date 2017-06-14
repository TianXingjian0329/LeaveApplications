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
import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.service.ApplicationService;
import edu.iss.sa44team8laps.service.LeaveTypeService;



	@Controller
	@RequestMapping(value = "/employee")
	public class ApplicationController {
		@Autowired
		private ApplicationService appservice;	
		@Autowired
		private LeaveTypeService ltservice;

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
		

	}
	
