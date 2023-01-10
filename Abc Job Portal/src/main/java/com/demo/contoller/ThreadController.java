package com.demo.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.ThreadService;
import com.demo.service.UserService;
import com.demo.model.Comments;
import com.demo.model.Thread;
import com.demo.model.User;
@Controller
public class ThreadController {

	@Autowired
	private ThreadService threadService;
	@Autowired
	private UserService userService;
	
//	for froum page displaying thread list
	@RequestMapping(value = "/forum", method = RequestMethod.GET)
	public ModelAndView showAllThread(ModelAndView model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
        model.addObject("user", userId);
        
		List<Thread> thread = threadService.showAllThread();
		model.addObject("threadlist", thread);
		model.setViewName("thread");
		return model;
	}
//	display new thread page containing new thread form
	@RequestMapping(value="/newthread", method = RequestMethod.GET)
	public ModelAndView newThread(ModelAndView model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
		model.addObject("user", userId);
		model.addObject("thread", new Thread());
		model.setViewName("thread-new");
		return model;
	}
//	save new thread data to database 
	@RequestMapping(value="/savethread", method = RequestMethod.POST)
	public ModelAndView addThread(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("thread") Thread thread) {
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
		threadService.addThread(userId,thread);
		return new ModelAndView("redirect:/forum");
	}
//	display list thread that user have posted before
	@RequestMapping("/my-thread")
	public ModelAndView myThread(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
		
		List<Thread> listUserThread = threadService.listUserThread(userId.getUserID());
		
		mv.addObject("listUserThread", listUserThread);
		mv.setViewName("thread-user");
		return mv;
	}
//	display specified thread detail and also containing comment
	@RequestMapping(value="/thread", method = RequestMethod.GET)
	public ModelAndView readThread(@RequestParam("id") Long id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
		
		Thread thread = threadService.findThreadById(id);
		Comments comment = new Comments();
		
		List<Comments> listComment = threadService.listComment(id);
		
		mv.addObject("listComment", listComment);
		mv.addObject("th", thread);
		mv.addObject("threadComment", comment);
		mv.setViewName("thread-read");
		return mv;
	}
//	save comment data to specified thread
	@RequestMapping(value = "/postComment", method = RequestMethod.POST)
	public ModelAndView postComment(@ModelAttribute("threadComment") Comments comment, @RequestParam("id") Long id, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
        User userId = (User)session.getAttribute("userlog");
		Thread thread = threadService.findThreadById(id);
		
		
		threadService.postComment(comment, thread, userId);
		
		return new ModelAndView("redirect:/forum");
	}
}
