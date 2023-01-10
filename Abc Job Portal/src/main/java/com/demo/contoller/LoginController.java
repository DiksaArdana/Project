package com.demo.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.model.Constants;

@Controller
public class LoginController {

	@Autowired
	public UserService userService;

	/*
	 * mapping url for the login page and connect it to the database
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginDto", new User());

		return mav;
	}

	/*
	 * retrieve input email and password from user
	 * and will be check against data in database
	 * then validate the role and set up session
	 * */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView loginUser(@ModelAttribute ("loginDto") User loginDto, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        User userResponse = userService.loginUser(loginDto);
        if (null == userResponse) {
            ModelAndView model = new ModelAndView();
            User user = new User();
            model.addObject("user", user);
            model.addObject("response", Constants.USER_LOGIN_FAILED);
            model.setViewName("login");
            return model;
        }
        if (userResponse.getRole().equals(Constants.USER_ROLE)) {
            session.setAttribute("userlog", userResponse);
            session.setAttribute("userId", userResponse.getUserID());
            return new ModelAndView("redirect:jobs");
        }  

        else {
        	session.setAttribute("userlog", userResponse);
            return new ModelAndView("redirect:admin/dashboard");
        }
    }
	
	/*
	 * logout controller, to invalidate the session
	 * and goes back to landing page
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("redirect:/");
	}

}
