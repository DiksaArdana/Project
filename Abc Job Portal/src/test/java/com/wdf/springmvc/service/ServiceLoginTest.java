package com.wdf.springmvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.config.JpaConfig;
import com.demo.config.ViewRes;
import com.demo.model.User;
import com.demo.repo.UserRepository;
import com.demo.service.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes= {ViewRes.class, JpaConfig.class})
class ServiceLoginTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServiceImpl userService;

	@Test
	void testLogin() {
		String email = "gusdiksa02@gmail.com";
		String password = "diksa123";
		int role = 1;
		
		User user = userService.findByEmail(email);
		
		assertEquals(password, user.getPass());
		assertEquals(role,user.getRole());
		assertNotNull(user);
		
	}

}
