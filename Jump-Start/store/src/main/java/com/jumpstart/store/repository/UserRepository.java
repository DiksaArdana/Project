package com.jumpstart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Products;
import com.jumpstart.store.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM users_tb WHERE role = 'rider'", nativeQuery = true)
	public List<User> findRider();
}
