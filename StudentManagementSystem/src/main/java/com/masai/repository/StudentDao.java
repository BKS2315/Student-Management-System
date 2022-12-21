package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	
	public Student findByMobileNumber(String mob);
	
	public List<Student> findByStudentName(String name);

}
