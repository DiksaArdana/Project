package com.demo.contoller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;

import com.demo.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	public UserService userService;
	
	
	/*
	 * mapping url for the login page and connect it to the database
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());

		return mav;
	}

	/*
	 * controller for save the input data to the database
	 * goes back to dashboard
	 * */
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user, ModelAndView mav) {
		User checkEmail = userService.findByEmail(user.getEmail());
		
		if (checkEmail != null) {
			mav.setViewName("register");
			mav.addObject("dupe", "Email already registered");
			return mav;
		} else {
			userService.register(user);
			mav.addObject("firstName", user.getFirstName());
			mav.setViewName("confirm");
			return mav;
		
		}
	}

}
