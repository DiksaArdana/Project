package com.lithan.AbcCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.AbcCar.entity.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

  public UserAccount findByUsername(String username);

}