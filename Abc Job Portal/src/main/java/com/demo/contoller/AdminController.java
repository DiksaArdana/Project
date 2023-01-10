package com.demo.contoller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Job;
import com.demo.model.User;

import com.demo.service.EmailService;
import com.demo.service.UserService;
import com.demo.service.JobService;


@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JobService jobService;


	/*
	 * controller for see admin profile get the session and retrieve data from
	 * database
	 */
	@RequestMapping(value = "/adprofile", method = RequestMethod.GET)
	public ModelAndView seeProfile(HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		Long userId = (Long) session.getAttribute("userId");

		User user = userService.findUserById(userId);

		model.addObject("user", user);
		model.setViewName("admin-profile");

		return model;
	}

	/*
	 * controller for listing all user from database then pass it to the view
	 */
	@RequestMapping(value = "/dashboard")
	public ModelAndView showAllUsers(ModelAndView model) {
		List<User> listuser = userService.showAllUsers();
		model.addObject("listuser", listuser);
		model.setViewName("admin-dashboard");

		return model;
	}

	/*
	 * controller for adding new user goes to add form
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("admin-add");
		mav.addObject("user", new User());

		return mav;
	}

	/*
	 * controller for retrieve data that will be edit goes to edit form
	 */
	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable Long id, ModelAndView model) {
		User user = userService.findUserById(id);

		if (user == null) {
			model.addObject("msg", "Edit User data Can't be found.");
			model.setViewName("filenotfound");
		} else {
			model.addObject("user", user);
			model.setViewName("admin-edit");
		}

		return model;
	}

	/*
	 * controller for collecting the edited data passed it to database goes back to
	 * dashboard
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("pass") String pass, @RequestParam("address") String address,
			@RequestParam("workexp") String workexp, @RequestParam("education") String education,
			@RequestParam("cerificate") String cerificate, @RequestParam("skill") String skill,
			@RequestParam("userID") Long userID) {

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPass(pass);
		user.setAddress(address);
		user.setWorkexp(workexp);
		user.setEducation(education);
		user.setCerificate(cerificate);
		user.setSkill(skill);
		user.setUserID(userID);

		userService.updateUser(user);

		return new ModelAndView("redirect:/admin/dashboard");

	}

	/*
	 * controller for save the input data to the database goes back to dashboard
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveChange(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		userService.register(user);

		return new ModelAndView("redirect:/admin/dashboard");
	}

	/*
	 * controller for delete user data by using the user id to specify which one
	 */
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);

		return new ModelAndView("redirect:/admin/dashboard");
	}
	/*================================================================================================*/
	/*
	 * controller for display mailing form
	 */
	@RequestMapping(value = "/mailform")
	public ModelAndView mailForm(ModelAndView model) {

		model.setViewName("admin-email");

		return model;
	}
	/*
	 * controller for send message to specified user email
	 */
	@RequestMapping(value = "/bulkEmail", method = RequestMethod.POST)
	public String bulkEmail(HttpServletRequest request, HttpServletResponse response, Model model) {

		String to = request.getParameter("mailto");
		String subject = request.getParameter("mailSubject");
		String content = request.getParameter("mailMsg");
		try {

			emailService.sendBulkEmail(to, subject, content);

			model.addAttribute("msg", "Mail sended successfully.");

		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error while sending email");
		}

		return "admin-email";
	}
	/*================================================================================================*/	
	/*
	 * controller for display job dashboard
	 */
	@RequestMapping(value = "/jobboard")
	public ModelAndView showAllJob(ModelAndView model) {
		List<Job> listjob = jobService.showAllJob();
		model.addObject("listjob", listjob);
		model.setViewName("admin-jobs");

		return model;
	}
	/*
	 * controller for display adding job form
	 */
	@RequestMapping(value = "/addjob", method = RequestMethod.GET)
	public ModelAndView addJob() {
		ModelAndView mav = new ModelAndView("admin-jobs-add");
		mav.addObject("job", new Job());

		return mav;
	}
	/*
	 * controller for save new job data 
	 */
	@RequestMapping(value = "/savejob", method = RequestMethod.POST)
	public ModelAndView saveJobChange(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("job") Job job) {

		jobService.addJob(job);

		return new ModelAndView("redirect:/admin/jobboard");
	}
	/*
	 * controller for delete job data by using the job id to specify which one
	 */
	@RequestMapping(value = "/deletejob/{id}", method = RequestMethod.GET)
	public ModelAndView deleteJob(@PathVariable Long id) {
		jobService.deleteJob(id);

		return new ModelAndView("redirect:/admin/jobboard");
	}
	/*
	 * controller for display edit job data form by using the user id to specify which one
	 */
	@RequestMapping(value = "/editjob/{id}", method = RequestMethod.GET)
	public ModelAndView editJob(@PathVariable Long id, ModelAndView model) {
		Job job = jobService.findJobById(id);
		if (job == null) {
			model.addObject("msg", "Edit User data Can't be found.");
			model.setViewName("admin-jobs");
		} else {
			model.addObject("job", job);
			model.setViewName("admin-jobs-edit");
		}
		return model;
	}
	/*
	 * controller for edit job data by using the user id to specify which one
	 */
	@RequestMapping(value = "/edit-jobs", method = RequestMethod.POST)
	public ModelAndView updateJob(@RequestParam("jobTitle") String jobTitle,
			@RequestParam("jobCategory") String jobCategory, @RequestParam("company") String company,
			@RequestParam("comAddress") String comAddress, @RequestParam("jobDesc") String jobDesc,
			@RequestParam("status") Integer status,@RequestParam("jobId") Long jobId) 
	{
		Job job = new Job();
		job.setJobTitle(jobTitle);
		job.setJobCategory(jobCategory);
		job.setCompany(company);
		job.setComAddress(comAddress);
		job.setJobDesc(jobDesc);
		job.setStatus(status);
		job.setJobId(jobId);
		
		jobService.updateJob(job);
		return new ModelAndView("redirect:/admin/jobboard");

	}

}
