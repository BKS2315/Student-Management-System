package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	
	@NotNull(message = "Username cannot be null!")
	@NotBlank(message = "Username cannot be blank!")
	@Id
	private String username;
	
	@NotNull(message = "Password cannot be null!")
	@NotBlank(message = "Password cannot be blank!")
	private String password;
	
}
