package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.service.AuthenService;

@RestController
@RequestMapping("/auth")
public class AuthenController {

	@Autowired
	private AuthenService authenService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest request, HttpSession session) {
		String token = authenService.login(request);
		session.setAttribute("username", request.getUsername());
		return ResponseEntity.ok(Map.of("token", token));
	}

}
