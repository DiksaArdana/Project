package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	@Query(value = "Select * from users where :input IN(firstName, lastName)",
			nativeQuery = true)
	List<User> SearchUserByInput(@Param("input") String inp);
	
	Long deleteByUserID(Long id);

	User findByEmailAndPass(String email, String pass);

	User findByEmail(String email);
	
	User findByUserID(Long id);
	
}
