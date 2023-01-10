package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.JobsApply;

@Repository
public interface JobApplyRepository extends JpaRepository<JobsApply, Long> {

}
