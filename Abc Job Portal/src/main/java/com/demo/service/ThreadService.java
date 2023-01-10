package com.demo.service;

import java.util.List;

import com.demo.model.Comments;
import com.demo.model.Thread;
import com.demo.model.User;

public interface ThreadService {

	public Thread addThread(User user, Thread thread);
	
	public List<Thread> showAllThread();
	
	public Thread findThreadById(Long id);
	
	public List<Thread> listUserThread(Long id);
	
	public List<Comments> listComment(Long id);
	
	public void postComment(Comments comment, Thread thread, User user);
}
