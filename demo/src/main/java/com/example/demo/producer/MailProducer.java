package com.example.demo.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.RabbitMQConfig;
import com.example.demo.dto.EmailRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMail(EmailRequest request) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE,
            RabbitMQConfig.ROUTING_KEY,
            request
        );
    }
}