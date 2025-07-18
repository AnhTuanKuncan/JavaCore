package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailRequest {
	@Email
    @NotBlank
    private String to;
    private String subject;
    private String body;
}
