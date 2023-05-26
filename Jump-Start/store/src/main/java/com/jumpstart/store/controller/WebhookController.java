package com.jumpstart.store.controller;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jumpstart.store.dto.MessageDto;
import com.jumpstart.store.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class WebhookController {

  @Autowired
  private MessageService messageSender;

  @PostMapping(path = "/mail")
  public void sendMessage(@RequestParam("userName") String userName) {
    try {
		messageSender.sendEmailSubcription(userName);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}