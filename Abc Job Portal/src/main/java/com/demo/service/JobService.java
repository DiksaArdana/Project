package com.demo.service;


import java.util.List;

import com.demo.model.Job;
import com.demo.model.JobsApply;
import com.demo.model.User;

public interface JobService {
	
	public Job addJob(Job job);
	
	public List<Job> showAllJob();
	
	public Long deleteJob(Long id);
	
	public Job findJobById(Long id);
	
	public Job findJobsById(Long id);

	public void updateJob(Job job);
	
	public List<Job> sortJob(String cat);
	
	public List<Job> avalibleJob();
	
	public void postApply(JobsApply apply,User user, Job job);
}
