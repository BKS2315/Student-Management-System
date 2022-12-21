package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	
	@NotNull(message = "Name cannot be null!")
	@NotBlank(message = "Name cannot be blank!")
	private String studentName;
	
	@NotNull(message = "Date of birth cannot be null!")
	@NotBlank(message = "Date of birth cannot be blank!")
	private String dob;
	
	@NotNull(message = "Gender cannot be null!")
	@NotBlank(message = "Gender cannot be blank!")
	private String gender;
	
	@NotNull(message="Mobile number cannot be null!")
	@NotBlank(message= "Mobile number cannot be blank!")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number is invalid")
	@Size(min = 10, max = 10)
	private String mobileNumber;
	
	@Email
	private String email;
	
	@NotNull(message = "Father's name cannot be null!")
	@NotBlank(message = "Father's name cannot be blank!")
	private String fatherName;
	
	@NotNull(message = "Mother's name cannot be null!")
	@NotBlank(message = "Mother's name cannot be blank!")
	private String motherName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<StudentAddress> addressList = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
	private List<Course> courses = new ArrayList<>();
	

}
