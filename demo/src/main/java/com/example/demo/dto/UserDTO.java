package com.example.demo.dto;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotBlank(message = "Username không được để trống")
	@Size(min = 4, max = 20, message = "Username phải từ 4 đến 20 ký tự")
	private String username;

	@NotBlank(message = "Password không được để trống")
	@Size(min = 6, message = "Password phải từ 6 ký tự trở lên")
	private String password;

	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không đúng định dạng")
	private String email;

	@NotBlank(message = "Họ tên không được để trống")
	private String fullName;

	private boolean enabled;

	private Set<RoleDTO> roles;

	public User toEntity() {
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setEmail(this.email);
		user.setFullName(this.fullName);
		user.setEnabled(this.enabled);
		if (this.roles != null) {
			user.setRoles(this.roles.stream().map(RoleDTO::toEntity).collect(Collectors.toSet()));
		}
		return user;
	}

	public static UserDTO fromEntity(User user) {
		UserDTO dto = new UserDTO();
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setEmail(user.getEmail());
		dto.setFullName(user.getFullName());
		dto.setEnabled(user.isEnabled());
		if (user.getRoles() != null) {
			dto.setRoles(user.getRoles().stream().map(RoleDTO::fromEntity).collect(Collectors.toSet()));
		}
		return dto;
	}

}
