package com.demo.contoller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.AppendURL;
import com.demo.service.EmailService;
import com.demo.service.RandomString;
import com.demo.service.UserService;


@Controller
public class ForgotPasswordController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
	public String showForgotPassword() {
		
		// go to send email page
		return "forget-password";
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String forgotPassword( Model model, HttpServletRequest request) {
		
		// logic where sending email which has the link
	    String email = request.getParameter("email");
	    //create random string for link
	    String token = RandomString.getAlphaNumericString(10);
	    
	    System.out.println(email);
	    System.out.println(token);
	    
	    try {
	    	
	    	User user = userService.findByEmail(email);
	    	
	    	if (user != null) {
	    		user.setPass(token);
	    		user.setEmail(email);
	    		userService.updateResetPassword(user);
//	    		String resetPasswordLink = AppendURL.getSiteURL(request) + "/resetPassword?token=" + token;
	    		String resetPasswordLink = AppendURL.getSiteURL(request) + "/login";
	    		//send the email
	    		emailService.sendEmailLinkResetPassword(email, resetPasswordLink,token);
	    		
	    		System.out.println(resetPasswordLink);
	    		
	    		model.addAttribute("msg", "*We have sent a reset password link to your email. Please check.");
	    	} else {
	    		model.addAttribute("error", "Could not find any User with the email " + email);
	    	}
		} catch (UnsupportedEncodingException | MessagingException e) {
	        model.addAttribute("error", "Error while sending email");
	    }
		
		return "forget-password";
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public ModelAndView showResetPassword(@RequestParam(value = "token") Long token,ModelAndView model) {
		System.out.println(token);
		
		//show reset password bring the email here
		User user = userService.findUserById(token);
		model.addObject("user", user);
		
		if (user == null) {
			model.addObject("title", "Request for Reset Password Not Found");
			model.addObject("error", "Invalid Token. Please try to send email again.");
			model.setViewName("new-password");
			return model;
		}else {
			model.setViewName("new-password");
			return model;
		}
	}
	
	@RequestMapping(value = "/savePassword", method = RequestMethod.POST)
	public ModelAndView savePassword(HttpServletRequest request,ModelAndView model,@RequestParam("pass1") String pass,@RequestParam("userID") Long id) {
	    
	    User user = userService.findUserById(id);
		
		if (user == null) {
			model.addObject("title", "Request for Reset Password Not Found");
			model.addObject("error", "Invalid Token. Please try to send email again.");
			model.addObject("link", "forgetPassword");
			model.addObject("linked", "Back to forget password Page");
			model.setViewName("confirm-change");
			return model;
		} else {
			user.setPass(pass);
			user.getEmail();
			userService.resetPassword(user);
			model.addObject("title", "Reset Password Complete");
			model.addObject("msg", "You have succesfully change your password.");
			model.addObject("link", "login");
			model.addObject("linked", "Back to login page");
			model.setViewName("confirm-change");
			return model;
		}
		
	}
	
}
