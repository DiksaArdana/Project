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
@Table(name = "commenttb")
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commentID")
	private Long commentID;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="threadID")
	private Thread thread;
	
	public Comments() {}
	
	public Comments(String comments,User user,Thread thread) {
		super();
		this.comments=comments;
		this.user=user;
		this.thread=thread;
	}

	public Long getCommentID() {
		return commentID;
	}

	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}


	

}
