package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmailRequest;

@Service
public interface EmailService {
	void sendEmail(EmailRequest request);
}
