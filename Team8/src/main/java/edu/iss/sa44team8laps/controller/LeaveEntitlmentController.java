package edu.iss.sa44team8laps.controller;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.service.ApplicationService;
import edu.iss.sa44team8laps.service.LeaveTypeService;
import edu.iss.sa44team8laps.service.UserService;






@Controller
@RequestMapping(value= "/admin/entitlement")
public class LeaveEntitlmentController {
	
	@Autowired
	private ApplicationService aService;

	
/*	private static final LogManager logger = LogManager.getLogManager();*/
	
	private static final Logger LOGGER= Logger.getLogger(LeaveEntitlmentController.class.getName());
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView AllLeavePage(){
//		System.out.println("Get in LeaveList Mapping");
		ModelAndView mav = new ModelAndView("entitlement-list");
		List<Application> allApplication = aService.findAllApplications();
		mav.addObject("allApplication",allApplication);
//		System.out.println(allApplication.get(0));
		return mav;
		
	}
	
	@RequestMapping(value = "/update/{applicationid}", method = RequestMethod.GET )
	public ModelAndView editApp(@PathVariable Integer applicationid) {
//		LOGGER.info("Testing "+applicationid);
		Application application = aService.findAppById(applicationid);
		ModelAndView mav = new ModelAndView("entitlement-update","application",application);
		return mav;
	}
	
	//link to after update
		@RequestMapping(value = "/update/{applicationid}", method = RequestMethod.POST)
		public ModelAndView updateStaff(@ModelAttribute @Valid Application application,
				BindingResult result, @PathVariable Integer applicationid,
				final RedirectAttributes redirectAttributes) {
			if (result.hasErrors())
				return new ModelAndView("/update");
			aService.editApp(application);
			ModelAndView mav = new ModelAndView("redirect:admin/entitlement/list");
			//System.out.println(application.getApplicationId());
			
			return mav;
		}
		
		//link to after delete
		@RequestMapping(value = "/delete/{applicationid}", method = RequestMethod.POST)
		public ModelAndView deleteStaff(@ModelAttribute("application") @Valid Application application,
				BindingResult result, @PathVariable Integer applicationid,
				final RedirectAttributes redirectAttributes) {
			if (result.hasErrors())
				return new ModelAndView("/delete");
			
			ModelAndView mav = new ModelAndView("redirect:admin/entitlement/list");
			application.getApplicationId();
			aService.deleteApp(application);
			return mav;
		}
		
		

}