package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repo.CommentsRepository;
import com.demo.repo.ThreadRepository;
import com.demo.model.Comments;
import com.demo.model.Thread;
import com.demo.model.User;

@Service
public class ThreadServiceImpl implements ThreadService {

	@Autowired
	private ThreadRepository threadRepo;
	@Autowired
	private CommentsRepository commentRepo;
	
	public Thread addThread(User user,Thread thread) {
		thread.setUser(user);
		threadRepo.save(thread);
		return thread;
	}
	public List<Thread> showAllThread(){
		return threadRepo.findAll();
	}
	public Thread findThreadById(Long id) {
		Thread thread = threadRepo.findById(id).get();
		return thread;
	}
	public List<Thread> listUserThread(Long id){
		List<Thread> listThread = threadRepo.findByUserId(id);
		return listThread;
	}
	public List<Comments> listComment(Long id){
		List<Comments> listComment = commentRepo.findByIdThread(id);
		return listComment;
	}
	public void postComment(Comments comment, Thread thread, User user) {
		Comments postComment = new Comments();
		postComment.setUser(user);
		postComment.setThread(thread);
		postComment.setComments(comment.getComments());
		commentRepo.save(postComment);
	}
}
