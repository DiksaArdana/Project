package com.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Thread;


@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
	@Query(value = "SELECT * FROM threadtb WHERE userID = :id", nativeQuery = true)
	List<Thread> findByUserId(@Param("id")Long id);
	
}