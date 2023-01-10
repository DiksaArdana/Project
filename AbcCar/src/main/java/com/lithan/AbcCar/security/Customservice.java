package com.lithan.AbcCar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lithan.AbcCar.repository.UserRepository;
import com.lithan.AbcCar.entity.UserAccount;
import com.lithan.AbcCar.security.ApplicationUserDetail;



@Service
public class Customservice implements UserDetailsService {
    @Autowired
	UserRepository userrepo;
    UserAccount user;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user=userrepo.findByUsername(username);
		if(user==null) {
			System.out.println("User is Invalid");
		}
		return new ApplicationUserDetail(user);
	}

}
