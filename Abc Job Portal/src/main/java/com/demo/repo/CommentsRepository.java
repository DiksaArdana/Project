package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
	@Query(value = "SELECT * FROM commenttb WHERE threadID = :id", nativeQuery = true)
	List<Comments> findByIdThread(@Param("id")Long id);
}
