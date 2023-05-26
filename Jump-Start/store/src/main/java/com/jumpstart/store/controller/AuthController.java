package com.jumpstart.store.controller;

import com.jumpstart.store.dto.ApiResponse;
import com.jumpstart.store.dto.AuthResponse;
import com.jumpstart.store.dto.LoginRequest;
import com.jumpstart.store.dto.SignUpRequest;
import com.jumpstart.store.entity.AuthProvider;
import com.jumpstart.store.entity.User;
import com.jumpstart.store.exception.BadRequestException;
import com.jumpstart.store.repository.UserRepository;
import com.jumpstart.store.security.JwtGenerator;
import com.jumpstart.store.service.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtGenerator jwtGenerator;
    
    @Autowired
	private FileStorageService fileService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
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
        user.setImageUrl("https://t3.ftcdn.net/jpg/00/64/67/80/360_F_64678017_zUpiZFjj04cnLri7oADnyMH0XBYyQghG.jpg");
        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("api/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }
    @PostMapping("/edit-profile")
    public ResponseEntity<String> registerUser(@RequestParam("uid") long uid, @RequestParam("name") String name,
    		@RequestParam("phone") String phone,@RequestParam("address") String address, @RequestParam("image") MultipartFile image) {
    	String imageName = fileService.storeFile(image);
        String imageDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/file/downloadFile/")
               .path(imageName).toUriString();
    	// Creating user's account
        User update = userRepository.findById(uid).get();
        update.setName(name);
        update.setPhone(phone);
        update.setAddress(address);
        update.setImageUrl(imageDownloadUri);
        userRepository.save(update);

        return new ResponseEntity<>("Post Update User Successful! ",HttpStatus.OK);
    }
}
