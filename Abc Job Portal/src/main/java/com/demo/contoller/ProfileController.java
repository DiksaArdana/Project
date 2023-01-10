package com.demo.contoller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	public UserService userService;
	
	/*
	 * controller for see admin profile
	 * get the session and retrieve data from database
	 * */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView seeProfile(ModelAndView model, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
        Long userId = (Long)session.getAttribute("userId");
        
        User user = userService.findUserById(userId);
		model.addObject("user", user);
		model.setViewName("userprofile");
		return model;
	}
	
	/*
	 * controller for retrieve data that will be edit
	 * goes to edit form
	 * */
	@RequestMapping(value = "/updateprofile/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable Long id, ModelAndView model, HttpServletRequest request) {
		request.getSession(true);

        User listuser = userService.findUserById(id);
		
			model.addObject("user", listuser);
			model.setViewName("updateform");
		
		
		
		return model;
	}
	
	/*
	 * controller for collecting the edited data
	 * passed it to database
	 * goes back to dashboard
	 * */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateUser(
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("address") String address,@RequestParam("workexp") String workexp,
			@RequestParam("education") String education,@RequestParam("cerificate") String cerificate,
			@RequestParam("skill") String skill, @RequestParam("userID") Long userID) {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setWorkexp(workexp);
		user.setEducation(education);
		user.setCerificate(cerificate);
		user.setSkill(skill);
		user.setUserID(userID);
	
		userService.updateProfile(user);

		return new ModelAndView("redirect:/profile");
	}

}
