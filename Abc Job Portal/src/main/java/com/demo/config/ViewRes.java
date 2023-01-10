package com.demo.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan("com.demo.*")
@PropertySource("classpath:email.properties")
public class ViewRes implements WebMvcConfigurer{
	@Autowired
	private Environment env;
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/views/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
}
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry)
{
	   registry.addResourceHandler("/css/**")
       .addResourceLocations("/resource/css/") ;
	   registry.addResourceHandler("/js/**")
       .addResourceLocations("/resource/js/") ;
	   registry.addResourceHandler("/img/**")
       .addResourceLocations("/resource/img/") ;
	
}
@Bean
public JavaMailSender getJavaMailSender() {
	JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
	
	javaMailSenderImpl.setHost(env.getProperty("mail.Host"));
	javaMailSenderImpl.setUsername(env.getProperty("mail.Username"));
	javaMailSenderImpl.setPassword(env.getProperty("mail.Password"));
	javaMailSenderImpl.setPort(getIntProperty("mail.Port"));
	
	javaMailSenderImpl.setJavaMailProperties(getMailProperty());
	
	return javaMailSenderImpl;
}

private Properties getMailProperty() {
	
	Properties mailProperties = new Properties();
	mailProperties.put("mail.smtp.starttls.enable", true);
	mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
	
	return mailProperties;
}

int getIntProperty(String key) {
	
	String property = env.getProperty(key);
	
	return Integer.parseInt(property);
}
 
}