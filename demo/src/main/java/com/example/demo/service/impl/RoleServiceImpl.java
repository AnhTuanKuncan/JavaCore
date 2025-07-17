package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;

	@Override
	public List<RoleDTO> getAllRole() {
		return repository.findAll().stream().map(RoleDTO::fromEntity).collect(Collectors.toList());
	}

	@Override
	public RoleDTO getRoleById(Long id) {
		Role role = repository.findById(id).orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
		return RoleDTO.fromEntity(role);
	}

	@Override
	public RoleDTO createRole(RoleDTO roleDto) {
		Role saved = repository.save(roleDto.toEntity());
		return RoleDTO.fromEntity(saved);
	}

	@Override
	public RoleDTO updateRole(Long id, RoleDTO roleDto) {
		Role existing = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

		existing.setName(roleDto.getName());

		Role updated = repository.save(existing);
		return RoleDTO.fromEntity(updated);
	}

	@Override
	public void deleteRole(Long id) {
		repository.deleteById(id);
	}

}
