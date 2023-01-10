package com.demo.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface EmailService {
	
	public void sendEmailLinkResetPassword(String recipientEmail, String link, String tokens) throws MessagingException, UnsupportedEncodingException;
	
	public void sendBulkEmail(String to, String sub, String msg) throws MessagingException, UnsupportedEncodingException;
}
