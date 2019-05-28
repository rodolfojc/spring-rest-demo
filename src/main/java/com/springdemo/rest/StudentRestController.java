package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	//DEFINE @POSTCONTRUCT TO LOAD THE STUDENT DATA ONLY ONCE
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Rodolfo", "Carvajal"));
		theStudents.add(new Student("Lucy", "Lagunas"));
		theStudents.add(new Student("Juan", "Velasquez"));
		
	}
	
	
	//DEFINE ENDPOINT FOR /STUDENTS
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	//DEFINE ENDPOINT FOR /STUDENTS/{STUDENTID} RETURN STUDENT AT INDEX
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//JUST INDEX INTO THE LIST 
		
		return theStudents.get(studentId);
	} 
	
	
	
}
