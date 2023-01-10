package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "threadtb")
public class Thread {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "threadID")
	private Long threadID;
	
	@Column(name = "thread")
	private String thread;
	
	@Column(name = "tags")
	private String tags;
	
//	@Column(name = "userID")
//	private Long userID;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	public Thread(){
		
	}
	
	public Thread( User user, String thread,String tags) {
		super();
		this.user=user;
		this.thread =thread;
		this.tags=tags;
	}

	public Long getThreadID() {
		return threadID;
	}

	public void setThreadID(Long threadID) {
		this.threadID = threadID;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

//	public Long getUserID() {
//		return userID;
//	}
//
//	public void setUserID(Long userID) {
//		this.userID = userID;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	};
	
	
}
