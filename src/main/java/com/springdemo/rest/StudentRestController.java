package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//DEFINE ENDPOINT FOR /STUDENTS
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Rodolfo", "Carvajal"));
		theStudents.add(new Student("Lucy", "Lagunas"));
		theStudents.add(new Student("Juan", "Velasquez"));
		
		return theStudents;
	}
}
