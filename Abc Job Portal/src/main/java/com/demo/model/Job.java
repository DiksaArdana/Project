package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobstb")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "jobId")
	private Long jobId;
	
	@Column(name= "jobTitle")
	private String jobTitle;
	
	@Column(name="jobDesc")
	private String jobDesc;
	
	@Column(name="jobCategory")
	private String jobCategory;
	
	@Column(name="company")
	private String company;
	
	@Column(name="comAddress")
	private String comAddress;
	
	@Column(name="status")
	private Integer status;
	
	public Job() {
		
	}
	
	public Job(Long jobId, String jobTitle,String jobCategory, String jobDesc,String company,String comAddress, Integer status) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobCategory = jobCategory;
		this.jobDesc = jobDesc;
		this.company = company;
		this.comAddress = comAddress;
		this.status = status;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
