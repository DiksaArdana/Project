package com.lithan.kyn.controller;

import com.lithan.kyn.dto.UserDto;
import com.lithan.kyn.entity.User;
import com.lithan.kyn.exception.ResourceNotFoundException;
import com.lithan.kyn.repository.UserRepository;
import com.lithan.kyn.security.CurrentUser;
import com.lithan.kyn.security.UserPrincipal;

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

    @GetMapping("/me")
    public UserDto getLoginUser(Authentication authentication) {
      User user = userRepository.findByEmail(authentication.getName()).get();

      if (user == null) {
        throw new ResourceNotFoundException("User", "Email", authentication.getName());
      }
      return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
