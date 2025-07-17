package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAllUser();

	UserDTO getUserById(Long id);

	UserDTO createUser(UserDTO UserDTO);

	UserDTO updateUser(Long id, UserDTO userDto);

	void deleteUser(Long id);

}
