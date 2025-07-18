package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.demo.dto.EmailRequest;
import com.example.demo.service.EmailService;

public class EmailServiceImpl implements EmailService {
	@Autowired
	JavaMailSender mailSender;

	@Override
	public void sendEmail(EmailRequest request) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(request.getTo());
		message.setSubject(request.getSubject());
		message.setText(request.getBody());

		mailSender.send(message);

	}

}
