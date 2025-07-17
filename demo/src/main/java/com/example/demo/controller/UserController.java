package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping
	public List<User> getAllUsers() {
		return service.getAllUser();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@PostMapping
	public User createUser(@Valid @RequestBody UserDTO userDTO) {
		return service.createUser(userDTO.toEntity());
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
		return service.updateUser(id, userDTO.toEntity());
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
	}

}
