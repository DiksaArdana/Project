package com.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements EmailService {
	
    @Autowired
    private JavaMailSender mailSender;
    

	/*
	 * Service for sending the email using MimeMessage from Java Mail
	 * and MimeMessageHelper from Spring Mail
	 * */
	@Override
	public void sendEmailLinkResetPassword(String recipientEmail, String link, String tokens)
			throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Use this Temporary password for login</p>"
	            + "<p>Password:" + tokens + "</p>"
	            + "<p><a href=\"" + link + "\">Back To Login Page</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);

	}
	
	@Override
	public void sendBulkEmail(String to, String sub , String msg) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setTo(to);
	     
	    helper.setSubject(sub);
	     
	    helper.setText(msg, true);
	     
	    mailSender.send(message);

	}

}
