package com.jumpstart.store.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumpstart.store.dto.MessageDto;

@Service
public class MessageService {
	
	 @Autowired
	    private JavaMailSender mailSender;
		/*
		 * Service for sending the email using MimeMessage from Java Mail
		 * and MimeMessageHelper from Spring Mail
		 * */
		public void sendEmailSubcription(String recipientEmail)
				throws MessagingException, UnsupportedEncodingException {
			MimeMessage message = mailSender.createMimeMessage();              
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		    
		    helper.setTo(recipientEmail);
		     
		    String subject = "Subcription to Jumpstart retail store";
		     
		    String content = "<p>Hello,</p>"
		            + "<p>You have subcribe to Jumpstart website</p>"
		            + "<p>From now you will get every update to our promo event </p>"
		            + "<br>"
		            + "<p>Happy Shopping , "
		            + "Thank You :).</p>";
		     
		    helper.setSubject(subject);
		     
		    helper.setText(content, true);
		     
		    mailSender.send(message);

		}
		
//		@Override
//		public void sendBulkEmail(String to, String sub , String msg) throws MessagingException, UnsupportedEncodingException {
//			MimeMessage message = mailSender.createMimeMessage();              
//		    MimeMessageHelper helper = new MimeMessageHelper(message);
//		    
//		    helper.setTo(to);
//		     
//		    helper.setSubject(sub);
//		     
//		    helper.setText(msg, true);
//		     
//		    mailSender.send(message);
//
//		}
	//  private static final String HOOKS_URL = "https://hooks.slack.com/services/%s";
//
//  public void sendMessage(String userName, MessageDto message) throws JsonProcessingException {
//    Map<String, String> myMap = new HashMap<String, String>();
//    myMap.put(userName, "T04GTCXDCE7/B04HP9XQHA8/OUOYT4wiR94UXePNb9uULJyz");
//
//    String userChannelId = myMap.get(userName);
//    String userWebhookUrl = String.format(HOOKS_URL, userChannelId);
//    RestTemplate restTemplate = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//
//    headers.setContentType(MediaType.APPLICATION_JSON);
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    String messageJson = objectMapper.writeValueAsString(message);
//    HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
//
//    restTemplate.exchange(userWebhookUrl, HttpMethod.POST, entity, String.class);
//  }

}
