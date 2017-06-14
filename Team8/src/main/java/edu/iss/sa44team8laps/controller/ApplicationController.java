package edu.iss.sa44team8laps.controller;

	import java.text.SimpleDateFormat;
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
	import edu.iss.sa44team8laps.service.ApplicationService;



	@Controller
	@RequestMapping(value = "/employee")
	public class ApplicationController {
		@Autowired
		private ApplicationService appservice;	
		

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
				mav.addObject("history", appservice.findAppByUserId(us.getUser().getUserId()));
				return mav;
			}
			return mav;

		}

	}
	
