package com.masai.services;

import java.util.List;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;

public interface StudentService {
	
	public Student registerStudent(Student student) throws StudentException;
	
	public List<Student> getStudentByName(String name) throws StudentException;
	
	public Student updateStudentDetails(Student student) throws StudentException;
	
	public Course leaveTheCourse(Integer courseId,Integer studentId) throws CourseException,StudentException;

}
