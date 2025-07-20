package com.example.demo.service;

import com.example.demo.dto.EmailRequest;

public interface EmailService {
	void sendEmail(EmailRequest request);
}
