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
class ServiceCRUDTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServiceImpl userService;

	@Test
	void testRegister() {
		int random = (int)(Math.random() * 1000) +1;
		String email = "test" + random + "@email.com";
		User user = new User();
		user.setEmail(email);
		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setPass("test123");
		user.setRole(1);
		
		User saveduser = userService.register(user);
		
		assertEquals(email, saveduser.getEmail());
		
	}

//	@Test
//	void testDeleteUser() {
//		Integer userId = 2;
//		userService.deleteUser((long)userId);
//		
//	}

	@Test
	void testUpdateProfile() {
		User user = new User();
		user.setUserID((long)28);
		user.setEducation("Singapore University");
		user.setFirstName("Billy");
		
		
		userService.updateProfile(user);
		
		assertEquals(user.getEducation(), "Singapore University");
		assertEquals(user.getFirstName(), "Billy");
		
	}


}
