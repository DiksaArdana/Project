package com.wdf.springmvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.config.JpaConfig;
import com.demo.config.ViewRes;
import com.demo.model.Job;
import com.demo.repo.JobRepository;
import com.demo.service.JobServiceImpl;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes= {ViewRes.class, JpaConfig.class})
class ServiceJobTest {
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	JobServiceImpl jobService;

	@Test
	void testPostJob() {
		
		String jobtest = "Job Test";
		Job job = new Job();
		job.setJobTitle(jobtest);
		job.setJobCategory(jobtest);
		job.setCompany(jobtest);
		job.setComAddress(jobtest);
		job.setJobDesc(jobtest);
		job.setStatus(1);
		
		Job postjob = jobService.addJob(job);
		
		assertEquals(jobtest, postjob.getJobTitle());
		assertNotNull(postjob);
		
	}

	@Test
	void testUpdateJob() {
		Job job = new Job();
		job.setJobId((long)4);
		job.setJobDesc("Coding");
		
		
		
		jobService.updateJob(job);;
		
		assertEquals(job.getJobDesc(), "Coding");
		
	}



}
