package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthenticationRequest;

@Service
public interface AuthenService {
	
	String login(AuthenticationRequest authenticationRequest);

}
