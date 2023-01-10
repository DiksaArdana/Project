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
@Table(name = "job_apply_tb")
public class JobsApply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "applyID")
	private Long applyID;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="jobId")
	private Job job;
	
	@Column(name = "applyMessage")
	private String applyMessage;
	
	public JobsApply() {}
	
	public JobsApply(User user, Job job, String applymsg) {
		super();
		this.applyMessage=applymsg;
		this.user=user;
		this.job=job;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getApplyMessage() {
		return applyMessage;
	}

	public void setApplyMessage(String applyMessage) {
		this.applyMessage = applyMessage;
	}
	

}
