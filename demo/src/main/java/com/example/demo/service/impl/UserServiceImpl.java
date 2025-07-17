package com.example.demo.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<UserDTO> getAllUser() {
		return repository.findAll().stream().map(UserDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		return UserDTO.fromEntity(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User saved = repository.save(userDto.toEntity());
		return UserDTO.fromEntity(saved);
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO userDto) {
		User updateUser = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		updateUser.setFullName(userDto.getFullName());
		updateUser.setUsername(userDto.getUsername());
		updateUser.setEmail(userDto.getEmail());
		updateUser.setEnabled(userDto.isEnabled());
		updateUser.setPassword(userDto.getPassword());
		Set<Role> roleEntities = userDto.getRoles().stream().map(RoleDTO::toEntity).collect(Collectors.toSet());

		updateUser.setRoles(roleEntities);

		User updated = repository.save(updateUser);
		return UserDTO.fromEntity(updated);
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}

}
