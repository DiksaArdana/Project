package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Job;
import com.demo.model.JobsApply;
import com.demo.model.User;
import com.demo.repo.JobApplyRepository;
import com.demo.repo.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepo;
	@Autowired
	private JobApplyRepository applyRepo;

	public Job addJob(Job job) {
		return jobRepo.save(job);
	}
	public List<Job> showAllJob() {
		return jobRepo.findAll();
	}
	public Long deleteJob(Long id) {
		return jobRepo.deleteByJobId(id);
	}
	public Job findJobById(Long id) {
		return jobRepo.findByJobId(id);
	}
	public Job findJobsById(Long id) {
		Job job = jobRepo.findById(id).get();
		return job;
	}

	public void updateJob(Job job) {
		Job newJob = jobRepo.findByJobId(job.getJobId());
		newJob.setJobTitle(job.getJobTitle());
		newJob.setJobCategory(job.getJobCategory());
		newJob.setCompany(job.getCompany());
		newJob.setComAddress(job.getComAddress());
		newJob.setJobDesc(job.getJobDesc());
		newJob.setStatus(job.getStatus());
		jobRepo.save(newJob);
	}
	public List<Job> sortJob(String cat){
		List <Job> jobsorting = jobRepo.SortJobByCategory(cat);
		return jobsorting;
	}
	public List<Job> avalibleJob(){
		List <Job> jobslist = jobRepo.AvalibleJobByStatus();
		return jobslist;
	}
	public void postApply(JobsApply apply,User user, Job job) {
		JobsApply jobapply = new JobsApply();
		jobapply.setUser(user);
		jobapply.setJob(job);
		jobapply.setApplyMessage(apply.getApplyMessage());
		applyRepo.save(jobapply);
	}

}
