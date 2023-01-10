package com.lithan.AbcCar.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lithan.AbcCar.repository.UserRepository;
import com.lithan.AbcCar.entity.UserAccount;

@Service
@Transactional
public class UserService {
	private PasswordEncoder passwordencoder;
	@Autowired
	UserRepository repo;
	
	@Autowired
	public UserService(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.passwordencoder=encoder;
	}

	public UserAccount save(UserAccount user) {
		user.setRole("USER");
		user.setPassword(passwordencoder.encode(user.getPassword()));
		return repo.save(user);
	}
	public void updateUser(UserAccount user) {
		UserAccount newuser = get(user.getId());
		newuser.setUsername(user.getUsername());
		newuser.setName(user.getName());
		newuser.setEmail(user.getEmail());
		newuser.setPhone(user.getPhone());
		newuser.setFilePath(user.getFilePath());
		newuser.setFileSize(user.getFileSize());
		newuser.setFileType(user.getFileType());
		newuser.setImage(user.getImage());
		repo.save(newuser);
	}
	public void getPermission(UserAccount user) {
		UserAccount newuser = get(user.getId());
		newuser.setRole("ADMIN");
		repo.save(newuser);
	}
	public List<UserAccount> listAll() {
		return (List<UserAccount>) repo.findAll();
	}
	
	public UserAccount get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public UserAccount getUserByName(String username) {
		return repo.findByUsername(username);
	}
	

}
