package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Job;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	
	@Query(value = "SELECT * FROM jobstb where jobCategory= :cat AND status= 1",
			nativeQuery = true)
	List<Job> SortJobByCategory(@Param("cat") String cat);
	
	@Query(value = "SELECT * FROM jobstb where status= 1",
			nativeQuery = true)
	List<Job> AvalibleJobByStatus();
	Long deleteByJobId(Long id);
	Job findByJobId(Long id);
}