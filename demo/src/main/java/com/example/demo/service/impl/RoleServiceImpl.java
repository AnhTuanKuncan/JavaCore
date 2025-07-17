package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository repository;

	@Override
	public List<Role> getAllRole() {
		return repository.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
	}

	@Override
	public Role createRole(Role role) {
		return repository.save(role);
	}

	@Override
	public Role updateRole(Long id, Role role) {
		Role existing = getRoleById(id);
		existing.setName(role.getName());
		existing.setUsers(role.getUsers());
		return repository.save(existing);
	}

	@Override
	public void deleteRole(Long id) {
		repository.deleteById(id);
		;

	}

}
