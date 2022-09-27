package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.config.StudentNotFoundException;
import com.model.Student;
import com.model.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	static List<Student> list;
	
	
	//ExceptionHandler MEthod
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus_code(HttpStatus.NOT_FOUND.value());
//		error.setMessage(ex.getMessage());
//		error.setTimestramp(System.currentTimeMillis());
//		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
//		
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus_code(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(ex.getMessage());
//		error.setTimestramp(System.currentTimeMillis());
//		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
//		
//	}
	
	
	
	@PostConstruct
	public void loadData() {
		list=new ArrayList();
		list.add(new Student("Anil","Kumar"));
		list.add(new Student("Amit","Kumar"));
		list.add(new Student("Sunil","Kumar"));
		list.add(new Student("Suresh","Kumar"));
	}
	// Get Method
	//url --> api/gets -- for getting all students
	@GetMapping("/gets")
	public List<Student> getStudent(){
		return list;
	}
	//url for getting only one student api/student/stid
	@GetMapping("/student/{stid}")
	public Student getStudent(@PathVariable int stid) {
		return list.get(stid);
		
	}
	
	
	//POST Method
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		
		list.add(student);
		return student;
		
	}
	
	//Delete Operation
	@DeleteMapping("/student/{stid}")
	public void deleteStudent(@PathVariable int stid) {
		List<Student> list= getStudent();
		list.remove(stid);
	}
	
	//Put or Update
	@PutMapping("/student/{stid}")
	public void updateStudent(@PathVariable int stid){
		List<Student> list= getStudent();
		Student student = list.get(stid);
		student.setFname("Amol");
		student.setLname("Aman");
		
		
	}
	

}
