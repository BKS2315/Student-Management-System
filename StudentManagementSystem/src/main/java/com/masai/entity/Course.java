package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	@NotNull(message = "Course name cannot be null!")
	@NotBlank(message = "Course name cannot be blank!")
	private String courseName;
	
	@NotNull(message = "Course type cannot be null!")
	@NotBlank(message = "Course type cannot be blank!")
	private String courseType;
	
	@NotNull(message = "Course description cannot be null!")
	@NotBlank(message = "Course description cannot be blank!")
	private String description;
	
	@NotNull(message = "Course duration cannot be null!")
	@NotBlank(message = "Course duration cannot be blank!")
	private String courseDuration;
	
	@NotNull(message = "Topic cannot be null!")
	@NotBlank(message = "Topic cannot be blank!")
	private String topic;
	
	@JsonIgnore
	@ManyToMany
	private List<Student> students = new ArrayList<>();

}
