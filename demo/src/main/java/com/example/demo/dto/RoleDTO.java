package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

	@NotBlank(message = "Tên quyền không được để trống")
	private String name;

	public Role toEntity() {
		Role role = new Role();
		role.setName(this.name);
		return role;
	}

	public static RoleDTO fromEntity(Role role) {
		RoleDTO dto = new RoleDTO();
		dto.setName(role.getName());
		return dto;
	}

}
