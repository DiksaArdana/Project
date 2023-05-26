package com.jumpstart.store.controller;

import com.jumpstart.store.dto.ApiResponse;
import com.jumpstart.store.dto.SignUpRequest;
import com.jumpstart.store.entity.AuthProvider;
import com.jumpstart.store.entity.Category;
import com.jumpstart.store.entity.Products;
import com.jumpstart.store.entity.User;
import com.jumpstart.store.repository.UserRepository;
import com.jumpstart.store.service.FileStorageService;
import com.jumpstart.store.service.ProductsService;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

    @PostMapping("/post-user")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email address is already taken!.",HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setAddress(signUpRequest.getAddress());
        user.setPhone(signUpRequest.getPhone());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(signUpRequest.getRole());
        userRepository.save(user);

        return new ResponseEntity<>("Post User Successful! ",HttpStatus.OK);
    }
    @GetMapping("/user-list")
   	public List<User> Userlist() {
   		List<User> result = userRepository.findAll();
   		return result;		
   	}
    @GetMapping("/rider-list")
   	public List<User> Riderlist() {
   		List<User> result = userRepository.findRider();
   		return result;		
   	}
    @GetMapping("/profile/{uid}")
    public User UserProfile(@PathVariable("uid")long uid) {
    	User result = userRepository.findById(uid).get();
    	return result;
    }
    
}
