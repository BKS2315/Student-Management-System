package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	
	public Course findByCourseName(String courseName);

}
