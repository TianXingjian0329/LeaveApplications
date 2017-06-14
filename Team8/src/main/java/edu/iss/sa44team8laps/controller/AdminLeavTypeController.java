package edu.iss.sa44team8laps.controller;


import java.util.ArrayList;
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


import edu.iss.sa44team8laps.model.LeaveType;

import edu.iss.sa44team8laps.service.LeaveTypeService;


@RequestMapping(value="/admin/leavetype")
@Controller
public class AdminLeavTypeController {

//	@Autowired
//	private RoleService rService;
	
	@Autowired
	private LeaveTypeService lService;
	
	/*@Autowired
	private UserValidator uValidator;
*/
/*	@InitBinder("leavetype")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(rValidator);
	}
*/
	/**
	 * USER CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newUserPage() {
		return "employee-new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid LeaveType leaveType, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("user-new");

		ModelAndView mav = new ModelAndView();
		String message = "New leave type " + leaveType.getLeaveId() + " was successfully created.";

		lService.createLeaveType(leaveType);
		mav.setViewName("redirect:/admin/leavetype/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("leavetype-list");
		ArrayList<LeaveType> LeaveTypelist = lService.findAllLeaveType();
		mav.addObject("LeaveTypeList", LeaveTypelist);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLeaveTypePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("leavetype-edit");
		LeaveType leaveType = lService.findById(id);
		mav.addObject("LeaveType", leaveType);
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid LeaveType leaveType, BindingResult result,
			final RedirectAttributes redirectAttributes) /*throws LeaveTypeNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("leavetype-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/leavetype/list");
		lService.updateLeaveType(leaveType);
		String message = "Leave type was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int id, final RedirectAttributes redirectAttributes)
			/*throws LeaveTypeNotFound*/ {

		ModelAndView mav = new ModelAndView("redirect:/admin/leavetype/list");
		LeaveType leaveType = lService.findById(id);
		lService.deleteLeaveType(leaveType);
		String message = "The leave type " + leaveType.getLeaveId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	


}
