package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.dto.EmailRequest;
import com.example.demo.service.EmailService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailConsumer {
	@Autowired
	EmailService emailService; 
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleEmailMessage(EmailRequest request) {
        try {
        	emailService.sendEmail(request);
          
        } catch (Exception ex) {
            
        }
    }
}