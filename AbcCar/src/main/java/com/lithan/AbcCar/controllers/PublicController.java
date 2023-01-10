package com.lithan.AbcCar.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.AbcCar.entity.UserAccount;
import com.lithan.AbcCar.services.UserService;

import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.services.CarService;

@Controller
public class PublicController {
	@Autowired
	private UserService userService;
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="/",  method= RequestMethod.GET)
    public String handleRootRequest(Model model) {
        return "redirect:home";
    }
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {

		model.setViewName("home");
		
		return model;
	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(ModelAndView model) {

		model.setViewName("about");
		
		return model;
	}
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView contact(ModelAndView model) {

		model.setViewName("contact");
		
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model) {
		model.setViewName("login");
		
		return model;
	}
	@RequestMapping(value="/login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again!";
        model.addAttribute("error_string", error_msg);
        return "login";
    }
//	---register--
	@RequestMapping(value="/new")
	public String newUserForm(Map<String, Object> model) {
    	System.out.println("/new Login Controller");
		UserAccount user = new UserAccount();
		model.put("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStore(@ModelAttribute("user") UserAccount user,ModelAndView model) {
		UserAccount checkUsername = userService.getUserByName(user.getUsername());
		
		if (checkUsername != null) {
			model.setViewName("register");
			model.addObject("dupe", "Username already registered!");
		} else {
			userService.save(user);
			String register_success = "<h5> Registeration Successful! </h5> <a href=\"login\"> Sign In</a> to use our portal...";
			model.addObject("dupe", register_success);
			model.setViewName("register");
		}
		return model;
	}
	@RequestMapping(value="cars",  method= RequestMethod.GET)
    public String viewCars(Model model) {
        List<Car> cars = carService.listUserCarByStatus();
        if(!CollectionUtils.isEmpty(cars)) {
            model.addAttribute("carlist", cars);
        }
        return "cars";
    }
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Car> result = carService.search(keyword);
		ModelAndView mav = new ModelAndView("cars");
		mav.addObject("carlist", result);
		return mav;		
	}
}
