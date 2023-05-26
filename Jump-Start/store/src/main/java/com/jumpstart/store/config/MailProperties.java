package com.jumpstart.store.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Component
public class MailProperties {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("tstdeep7@gmail.com");
		javaMailSenderImpl.setPassword("zuqnplgfgbcktnwr");
		javaMailSenderImpl.setPort(587);
		
		javaMailSenderImpl.setJavaMailProperties(getMailProperty());
		
		return javaMailSenderImpl;
	}

	private Properties getMailProperty() {
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); 
		
		return mailProperties;
	}

}
