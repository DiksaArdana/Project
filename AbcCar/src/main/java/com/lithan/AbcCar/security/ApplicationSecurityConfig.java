package com.lithan.AbcCar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordencoder;
    @Autowired
    UserDetailsService userservice;
	@Autowired
	UserDetailsService userdetail;
    @Autowired
    ApplicationSecurityConfig (PasswordEncoder encoder){
    	this.passwordencoder=encoder;
    }
//    @Autowired
//    RolesHandler roles;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
        .antMatchers("/img/**").permitAll()
        .antMatchers("/js/**").permitAll()
		.antMatchers("/", "/home", "/about", "/contact","/new","/save","/cars").permitAll()
		.antMatchers(HttpMethod.GET,"/profile").hasAnyAuthority("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/user-detail").hasAnyAuthority("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/edit-profile").hasAuthority("USER")
		.antMatchers(HttpMethod.POST,"/update-profile").hasAnyAuthority("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/add-car").hasAuthority("USER")
		.antMatchers(HttpMethod.POST,"/save-car").hasAuthority("USER")
		.antMatchers(HttpMethod.GET,"/my-car").hasAuthority("USER")
		.antMatchers(HttpMethod.GET,"/detail-car").hasAnyAuthority("USER","ADMIN")
		.antMatchers(HttpMethod.GET,"/edit-car").hasAuthority("USER")
		.antMatchers(HttpMethod.POST,"/update-car").hasAuthority("USER")
		.antMatchers(HttpMethod.POST,"/update-status").hasAnyAuthority("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/car_bidding").hasAuthority("USER")
		.antMatchers(HttpMethod.POST,"/booking").hasAuthority("USER")
		.antMatchers(HttpMethod.GET, "/delete").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/delete").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.GET,"/admin").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.POST,"/update-roles").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.GET,"/cars-list").hasAuthority("ADMIN")
        .antMatchers(HttpMethod.GET,"/edit-admin-profile").hasAuthority("ADMIN")
		.and()
		.formLogin()
		.loginPage("/login").loginProcessingUrl("/loginUser").failureUrl("/login_error")
		.permitAll()
		.defaultSuccessUrl("/cars", true)
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.clearAuthentication(true)
		.invalidateHttpSession(true);
	}
	@Autowired
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider  dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordencoder);
		dao.setUserDetailsService(userservice);
		
		return dao;
	}

}
