package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.repository.CourseDao;
import com.masai.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sd;
	
	@Autowired
	private CourseDao cd;

	@Override
	public Student registerStudent(Student student) throws StudentException {
		Student existingStudent= sd.findByMobileNumber(student.getMobileNumber());
		
		if(existingStudent != null) 
			throw new StudentException(" Student already registered with this mobile number!");
		
		return sd.save(student);
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentException {
		List<Student> students = sd.findByStudentName(name);
		
		if(students.size()>0) {
			return students;
		}else {
			throw new StudentException("No student found with name : "+name) ;
		}
			
	}

	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		Student existingStudent= sd.findByMobileNumber(student.getMobileNumber());
		
		if(existingStudent == null) 
			throw new StudentException(" Student doesn't exist with this mobile number!");
		
		return sd.save(student);
	}

	@Override
	public Course leaveTheCourse(Integer courseId, Integer studentId) throws CourseException, StudentException {
		Optional<Student> student = sd.findById(studentId);
		Optional<Course> course = cd.findById(courseId);
		Course courseFetched = course.get();
		
			if(student.isPresent()) {
				Student std = student.get();
				std.getCourses().remove(courseFetched);
				sd.save(std);
				courseFetched.getStudents().remove(std);
			}
	
		return cd.save(courseFetched);
	}

}
