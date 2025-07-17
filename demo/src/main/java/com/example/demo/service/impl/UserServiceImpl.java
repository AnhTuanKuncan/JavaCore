package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

	@Override
	public User createUser(User user) {
		return repository.save(null);
	}

	@Override
	public User updateUser(Long id, User user) {
		User updateUser = getUserById(id);
		updateUser.setFullName(user.getFullName());
		updateUser.setUsername(user.getUsername());
		updateUser.setEmail(user.getEmail());
		updateUser.setEnabled(user.isEnabled());
		updateUser.setPassword(user.getPassword());
		updateUser.setRoles(user.getRoles());

		return repository.save(updateUser);
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);

	}

}
