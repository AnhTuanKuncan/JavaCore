package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Role;

public interface RoleService {
	List<Role> getAllRole();

	Role getRoleById(Long id);

	Role createRole(Role role);

	Role updateRole(Long id, Role role);

	void deleteRole(Long id);

}
