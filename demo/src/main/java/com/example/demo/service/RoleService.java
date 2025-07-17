package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> getAllRole();

	RoleDTO getRoleById(Long id);

	RoleDTO createRole(RoleDTO roleDto);

	RoleDTO updateRole(Long id, RoleDTO roleDto);

	void deleteRole(Long id);

}
