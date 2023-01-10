
package com.lithan.AbcCar.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.entity.UserAccount;
import com.lithan.AbcCar.services.CarService;
import com.lithan.AbcCar.services.UserService;

@Controller 
 public class AdminController {
	 public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	@Autowired
	private UserService userService;
	@Autowired
	private CarService carService;
//	----------------- Admin---------------
	@RequestMapping(value="/admin",  method= RequestMethod.GET)
    public String viewUsers(Model model) {
        List<UserAccount> users = userService.listAll();
        if(!CollectionUtils.isEmpty(users)) {
            model.addAttribute("userlists", users);
        }
        return "admin-users";
    }
	  @PostMapping(value = "/update-roles")
		public String updatePermit(@RequestParam("userId") long Id) {
			
			UserAccount c = new UserAccount();
			c.setId(Id);
			userService.getPermission(c);

			return "redirect:/admin";
			
		}
	@RequestMapping("/delete-user")
	public String deleteCar(@RequestParam long id) {
		userService.delete(id);
		return "redirect:/admin";		
	}
	
	@RequestMapping(value="/cars-list",  method= RequestMethod.GET)
    public String viewCars(Model model) {
        List<Car> cars = carService.getAllCars();
        if(!CollectionUtils.isEmpty(cars)) {
            model.addAttribute("carlists", cars);
        }
        return "admin-cars";
    }
	@GetMapping("/edit-admin-profile")
	public ModelAndView userEditAdminProfile(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		String uname =authentication.getName();
		   
		UserAccount userid=userService.getUserByName(uname);
		
		mv.addObject("user", userid);
		mv.setViewName("profile-edit");
		return mv;
	}
  @PostMapping(value = "/update-admin-profile")
	public String updateAdminProfile(
			@RequestParam("userId") long Id, @RequestParam("userName") String userName,
			@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phone,@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		String fileName = file.getOriginalFilename().replaceAll(" ", "-");
		String filePath = Paths.get(uploadDirectory, fileName).toString();
		String fileType = file.getContentType();
		long size = file.getSize();
		String fileSize = String.valueOf(size);

		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserAccount c = new UserAccount();
		c.setId(Id);
		c.setUsername(userName);
		c.setName(fullName);
		c.setEmail(email);
		c.setPhone(phone);
		c.setFilePath(filePath);
		c.setFileSize(fileSize);
		c.setFileType(fileType);
		c.setImage(fileName);
		System.out.println(c + " 325");
		userService.updateUser(c);

		return "redirect:/profile";
		
	}
	

 }