package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService ss;
	
	@PostMapping("/student")
	public ResponseEntity<Student> registerStudentByAdmin(@Valid @RequestBody Student student) throws StudentException{
		
		Student savedStudent= ss.registerStudent(student);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) throws StudentException{
		
		Student savedStudent= ss.updateStudentDetails(student);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/")
	public ResponseEntity<List<Student>> getStudentsByNameHandler(@RequestParam("name") String name)
			throws StudentException {

		List<Student> studentsList = ss.getStudentByName(name);

		return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
	}
	
	@PostMapping("/{studentId}/{courseId}")
	public ResponseEntity<Course> leaveCourseByStudent(@Valid @PathVariable Integer studentId, @PathVariable Integer courseId) throws CourseException, StudentException{
		
		Course course = ss.leaveTheCourse(courseId, studentId);
		
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
		
	}
	

}
