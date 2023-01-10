package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User user) {
		return userRepo.save(user);
	}


	public User loginUser(User log) {
		User user = userRepo.findByEmailAndPass(log.getEmail(), log.getPass());
		System.out.println(user);
		if (user == null) {
			return null;
		}
		return user;
	}

	public void updateProfile(User user) {
		User newUser = userRepo.findByUserID(user.getUserID());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setWorkexp(user.getWorkexp());
		newUser.setAddress(user.getAddress());
		newUser.setEducation(user.getEducation());
		newUser.setCerificate(user.getCerificate());
		newUser.setSkill(user.getSkill());
		userRepo.save(newUser);
	}
	
	public void updateUser(User user) {
		User newUser = userRepo.findByUserID(user.getUserID());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPass(user.getPass());
		newUser.setWorkexp(user.getWorkexp());
		newUser.setAddress(user.getAddress());
		newUser.setEducation(user.getEducation());
		newUser.setCerificate(user.getCerificate());
		newUser.setSkill(user.getSkill());
		userRepo.save(newUser);
	}
	public Long deleteUser(Long id) {
		return userRepo.deleteByUserID(id);
	}
	public List<User> searchUser(String inp) {
		List<User> users = userRepo.SearchUserByInput(inp);
		return users;
	}
	
	public List<User> showAllUsers() {
		return userRepo.findAll();
	}
	public User findUserById(Long id) {
		return userRepo.findByUserID(id);
	}
	public void resetPassword(User userDto) {
		User user = userRepo.findByEmail(userDto.getEmail());
		user.setPass(userDto.getPass());
		userRepo.save(user);
	}

//	public User findByEmailId(String email) {
//		return userRepo.findByEmail(email);
//	}
	
	public User findByEmail (String email) {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			return null;
		}
		
		return user;
	}

	public void updateResetPassword(User userDto) {
		User user = userRepo.findByEmail(userDto.getEmail());
		user.setPass(userDto.getPass());
		userRepo.save(user);
	}
//
//	public User getByResetTokenPassword(String token) {
//		return userRepo.findByResetPasswordToken(token);
//	}
}
