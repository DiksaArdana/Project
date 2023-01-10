package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	public User register(User user);
	
	public User loginUser(User login);

	public void updateProfile(User user);
	
	public void updateUser(User user);
	
	public Long deleteUser(Long id);
	
	public List<User> searchUser(String inp);
	
	public List<User> showAllUsers();
	
	public User findUserById(Long id);
	
	
	public void resetPassword(User user);
	
//	public User findByEmailId (String email);
	
	public User findByEmail(String email);
	
	public void updateResetPassword(User user);

//	public User getByResetTokenPassword(String token);
}
