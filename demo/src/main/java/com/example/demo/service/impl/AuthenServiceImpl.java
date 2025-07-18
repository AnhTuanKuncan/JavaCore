package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.config.JwtProvider;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthenService;

public class AuthenServiceImpl implements AuthenService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public String login(AuthenticationRequest authenticationRequest) {
		User user = repository.findByName(authenticationRequest.getUsername()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		if (!passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return jwtProvider.generateToken(user.getUsername(), user.getRoles());
	}

}
