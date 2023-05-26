package com.jumpstart.store.controller;

import com.jumpstart.store.dto.UserDto;
import com.jumpstart.store.entity.User;
import com.jumpstart.store.exception.ResourceNotFoundException;
import com.jumpstart.store.repository.UserRepository;
import com.jumpstart.store.security.CurrentUser;
import com.jumpstart.store.security.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
//Authentication
    @GetMapping("/me")
    public UserDto getLoginUser(Authentication authentication) {
      User user = userRepository.findByEmail(authentication.getName()).get();

      if (user == null) {
        throw new ResourceNotFoundException("User", "Email", authentication.getName());
      }
      return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getAddress(), user.getPhone(), user.getImageUrl());
    }
}
