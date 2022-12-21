package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddress {
	
	@NotNull(message = "Address type cannot be null!")
	@NotBlank(message = "Address type cannot be blank!")
	@Id
	private String addressType;
	
	@NotNull(message = "Area cannot be null!")
	@NotBlank(message = "Area cannot be blank!")
	private String area;
	
	@NotNull(message = "District cannot be null!")
	@NotBlank(message = "District cannot be blank!")
	private String district;
	
	@NotNull(message = "State cannot be null!")
	@NotBlank(message = "State cannot be blank!")
	private String state;
	
	@NotNull(message = "Pincode cannot be null!")
	@NotBlank(message = "Pincode cannot be blank!")
	@Pattern(regexp="(^$|[0-9]{6})",message = "Pincode is invalid")
	@Size(min = 6, max = 6)
	private String pincode;

}
