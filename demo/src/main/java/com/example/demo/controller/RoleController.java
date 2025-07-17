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

import com.example.demo.dto.RoleDTO;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@GetMapping
	public List<RoleDTO> getAllRoles() {
		return roleService.getAllRole();
	}

	@GetMapping("/{id}")
	public RoleDTO getRoleById(@PathVariable Long id) {
		return roleService.getRoleById(id);
	}

	@PostMapping
	public RoleDTO createRole(@Valid @RequestBody RoleDTO roleDTO) {
		return roleService.createRole(roleDTO);
	}

	@PutMapping("/{id}")
	public RoleDTO updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
		return roleService.updateRole(id, roleDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable Long id) {
		roleService.deleteRole(id);
	}

}
