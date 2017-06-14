package edu.iss.sa44team8laps.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.service.ApplicationService;



@Controller
@RequestMapping(value= "/admin/entitlement")
public class LeaveEntitlmentController {
	
	@Autowired
	private ApplicationService aService;	
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView AllLeavePage(){
		ModelAndView mav = new ModelAndView("entitlement-list");
		List<Application> allApplication = aService.findAllApplications();
		mav.addObject("allApplication",allApplication);
		return mav;
		
	}
	
	@RequestMapping(value = "/update/{applicationid}", method = RequestMethod.GET )
	public ModelAndView editApp(@PathVariable Integer applicationid) {
		Application application = aService.findAppById(applicationid);
		ModelAndView mav = new ModelAndView("entitlement-update","application",application);
		return mav;
	}
	
		@RequestMapping(value = "/update/{applicationid}", method = RequestMethod.POST)
		public ModelAndView updateStaff(@ModelAttribute @Valid Application application,
				BindingResult result, @PathVariable Integer applicationid,
				final RedirectAttributes redirectAttributes) {
			ModelAndView mav = new ModelAndView("redirect:/admin/entitlement/list");
			aService.editApp(application);
			return mav;
		}

		@RequestMapping(value = "/delete/{applicationid}", method = RequestMethod.GET)
		public ModelAndView deleteStaff(@PathVariable Integer applicationid) {
			
			ModelAndView mav = new ModelAndView("redirect:/admin/entitlement/list");
			Application app=aService.findAppById(applicationid);
			aService.deleteApp(app);
			return mav;
		}
		
		

}