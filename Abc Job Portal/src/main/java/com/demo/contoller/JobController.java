package com.demo.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Job;
import com.demo.model.JobsApply;
import com.demo.model.User;
import com.demo.service.JobService;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
//	for display jobs page containing job list
	
	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ModelAndView showAllJob(ModelAndView model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
        model.addObject("user", userId);
		List<Job> listjob = jobService.avalibleJob();
		model.addObject("listjob", listjob);
		model.setViewName("jobs");

		return model;
	}
	
//	sorting job list by its category
	
	@GetMapping("/sort")
	    public ModelAndView searchUser(@RequestParam(value = "sortValue", required = false) String sortValue,
	    		HttpServletRequest request, HttpServletResponse response, ModelAndView model){
	        List<Job> jobListResponse = jobService.sortJob(sortValue);

	    		model.addObject("listjob", jobListResponse); 
	    	model.setViewName("jobs");
	        return model;
	    }
	
//	display job detail and input message for job apply 
	
	 @RequestMapping(value = "/seejob", method = RequestMethod.GET)
		public ModelAndView seeJob(@RequestParam("id") Long id, HttpServletRequest request) {
			ModelAndView model = new ModelAndView();
			HttpSession session = request.getSession(true);
	        User userId = (User)session.getAttribute("userlog");
			Job job = jobService.findJobsById(id);
			JobsApply jobapply = new JobsApply();
			
			model.addObject("job", job);
			model.addObject("jobapply", jobapply);
			model.setViewName("jobs-detail");
			return model;
		}
	 
//	post the job apply to database
	 
	 @RequestMapping(value = "/postapply", method = RequestMethod.POST)
		public ModelAndView postApply(HttpServletRequest request,@ModelAttribute("jobapply") JobsApply jobapply, @RequestParam("id") Long id){
		 ModelAndView model = new ModelAndView();
		 HttpSession session = request.getSession(true);
	     User userId = (User)session.getAttribute("userlog");
	     Job job = jobService.findJobsById(id);
	     
	     jobService.postApply(jobapply, userId, job);
	     model.addObject("title", "Your Job Application Has Been Send!");
	     model.addObject("msg", "We have recived your Job Application, we will contact you again");
	     model.addObject("link", "jobs");
	     model.addObject("linked", "Back to Job Page");
	     model.setViewName("confirm-change");
	     return model;
		}
}
