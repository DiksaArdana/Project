
  package com.lithan.AbcCar.controllers;
  import java.io.BufferedOutputStream;
  import java.io.File;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.io.InputStream;
  import java.nio.file.Files;
  import java.nio.file.Path;
  import java.nio.file.Paths;
  import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
  import java.util.Map;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.context.annotation.Bean;
  import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  //import org.springframework.util.StringUtils;
  import org.springframework.util.StringUtils;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.ModelAttribute;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.multipart.MultipartFile;
  import org.springframework.web.servlet.ModelAndView;
  import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lithan.AbcCar.entity.Booking;
import com.lithan.AbcCar.entity.Car;
import com.lithan.AbcCar.services.BidService;
import com.lithan.AbcCar.services.BookingService;
import com.lithan.AbcCar.services.CarService;
import com.lithan.AbcCar.services.UserService;
import com.lithan.AbcCar.entity.CarBidding;

import com.lithan.AbcCar.entity.UserAccount;
  
  
  @Controller 
  
  public class UserController {
	  public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	  @Autowired
	  private CarService carService;
	  
	  @Autowired
	  private UserService userService;
	  
	  @Autowired
	  private BidService carbidService;
	  
	  @Autowired
	  private BookingService carbookService;
//	  =================USER =====================================================================
	  @GetMapping("/profile")
		public ModelAndView userProfile( @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
			ModelAndView mv = new ModelAndView();
			String uname =authentication.getName();
			System.out.println(uname);   
			
			UserAccount userid=userService.getUserByName(uname);
			
			mv.addObject("user", userid);
			mv.setViewName("profile");
			return mv;
		}
	  @GetMapping("/user-detail")
		public ModelAndView userDetail(@RequestParam long id) {
			ModelAndView mv = new ModelAndView();
		
			UserAccount userid=userService.get(id);
			
			mv.addObject("user", userid);
			mv.addObject("dupe", "User");
			mv.setViewName("profile");
			return mv;
		}
	  @GetMapping("/edit-profile")
		public ModelAndView userEditProfile(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
			ModelAndView mv = new ModelAndView();
			String uname =authentication.getName();
			   
			UserAccount userid=userService.getUserByName(uname);
			
			mv.addObject("user", userid);
			mv.setViewName("profile-edit");
			return mv;
		}
	  @PostMapping(value = "/update-profile")
		public String updateProfile(
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
/* ---CAR Control--- */
		@GetMapping(value = "/add-car")
		public String myaddcarPage() {
			return "car-add";
		}
		
	@PostMapping(value = "/save-car")
	public String addCar(@RequestParam("carName") String carName, @RequestParam("carModel") String carModel,
			@RequestParam("carPrice") String carPrice, @RequestParam("carRegNumber") String carRegNumber, 
			@RequestParam("status") String st,@RequestParam("file") MultipartFile file,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication,Model mo) {
		Car regnum = carService.findCarRegistration(carRegNumber);
		if (regnum != null) {
			mo.addAttribute("email", "Registration Number Already Exists!");
		}else {
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
			String uname =authentication.getName();
			UserAccount userid=userService.getUserByName(uname);
			
			Car c = new Car();
			c.setUserId(userid);
			c.setMake(carName);
			c.setModel(carModel);
			c.setPrice(carPrice);
			c.setRegistration(carRegNumber);
			c.setFilePath(filePath);
			c.setFileSize(fileSize);
			c.setFileType(fileType);
			c.setImage(fileName);
			c.setStatus(st);
			carService.saveCar(c);
			String successmsg = "<h5> Car Successfully Posted! </h5> <a href=\"my-car\"> Dashboard</a>";
			mo.addAttribute("msgPost", successmsg);
		}
		return "car-add";
	}
	@GetMapping("/my-car")
	public ModelAndView myThread(@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		String uname =authentication.getName();
		UserAccount userid=userService.getUserByName(uname);
		List<Car> listUserCar = carService.listUserCar(userid.getId());
		
		mv.addObject("mycarlist", listUserCar);
		mv.setViewName("cars-my");
		return mv;
	}
	@GetMapping("/detail-car")
	public ModelAndView carDetail(@RequestParam long id,@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		ModelAndView mav = new ModelAndView("car-detail");
		Car car = carService.get(id);
		long dcar= car.getUserId().getId();
		String uname =authentication.getName();   
		UserAccount userid=userService.getUserByName(uname);
		long loguser = userid.getId();
		   if(dcar == loguser) {
			   mav.addObject("dupe", "carowner");
			   mav.addObject("car", car);
			   mav.addObject("bidinfo", carbidService.listBidInfo((car)));
			   mav.addObject("bookinfo", carbookService.listBookInfo((car)));
		   }
		   else { 
			   mav.addObject("car", car);
			   mav.addObject("bidinfo", carbidService.listBidInfo((car)));
		   }
		return mav;
	}
	@GetMapping("/edit-car")
	public ModelAndView carUpdate(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("car-edit");
		Car car = carService.get(id);
		mav.addObject("car", car);
		return mav;
	}
	@PostMapping(value = "/update-car")
	public String updateCar(
			@RequestParam("cardId") long cardId, @RequestParam("carName") String carName,
			@RequestParam("carModel") String carModel, @RequestParam("carPrice") String carPrice,
			@RequestParam("carRegNumber") String carRegNumber,@RequestParam("file") MultipartFile file,
			@CurrentSecurityContext(expression = "authentication") Authentication authentication) {
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
		String uname =authentication.getName();     
		UserAccount userid=userService.getUserByName(uname);
		
		Car c = new Car();
		c.setId(cardId);
		c.setUserId(userid);
		c.setMake(carName);
		c.setModel(carModel);
		c.setPrice(carPrice);
		c.setRegistration(carRegNumber);
		c.setFilePath(filePath);
		c.setFileSize(fileSize);
		c.setFileType(fileType);
		c.setImage(fileName);
		System.out.println(c + " 325");
		carService.UpdateaddCar(c);

		return "redirect:/my-car";
		
	}
	@PostMapping(value = "/update-status")
	public String updateCarStatus(@RequestParam("carIds") long Id) {
		
		Car c = new Car();
		c.setId(Id);
		carService.UpdateStatus(c);

		return "redirect:/my-car";
		
	}

/*----- Car Bidding -----------------------*/
	@RequestMapping(value="/car_bidding", method = {RequestMethod.POST})
	public  ModelAndView saveBid(@RequestParam(value="id", required = false) Long id,
							@RequestParam("bitprice") String bidderPrice) {
		ModelAndView mav = new ModelAndView();
		String uname="";
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   if(principal instanceof UserDetails) {
			    uname=((UserDetails) principal).getUsername();
			 
		   }
		   else {
			    uname=principal.toString();
		   }
		   
		   Long carid=id;
		   Car car = carService.get(id);
		   UserAccount user=userService.getUserByName(uname);
		   Date cur_time=new Date();
		   

	       CarBidding carBitInfo = new CarBidding();
	       carBitInfo.setBidderName(uname);
	       carBitInfo.setBidderPrice(bidderPrice);
	       carBitInfo.setCar(car);
	       carBitInfo.setUser(user);
	       carBitInfo.setBid_date_time(cur_time);
	       
	       CarBidding savedCar = carbidService.save(carBitInfo);

	       mav.addObject("car", car);		
	       mav.addObject("bidinfo", carbidService.listBidInfo(car));
	       mav.setViewName("car-detail");
	       return mav;
	}
/*----- Car Test Drive Book  -----------------------*/
	@RequestMapping(value="/booking", method = {RequestMethod.POST})
	public  ModelAndView saveBook(@RequestParam(value="id", required = false) Long id,
							@RequestParam("keydate") String bookDate, @CurrentSecurityContext(expression = "authentication") Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		String uname = authentication.getName();
		   
		   Car car = carService.get(id);
		   UserAccount user=userService.getUserByName(uname);
		   
	       Booking carBookInfo = new Booking();
	       carBookInfo.setDate(bookDate);
	       carBookInfo.setCar(car);
	       carBookInfo.setUser(user);

	       
	       Booking savedBook = carbookService.save(carBookInfo);

	       mav.addObject("car", car);		
	       mav.addObject("bidinfo", carbidService.listBidInfo(car));
	       mav.addObject("bookmsg", "You have booking  for test drive, we will contact you soon!");
	       mav.setViewName("car-detail");
	       return mav;
	}
  
  }
 