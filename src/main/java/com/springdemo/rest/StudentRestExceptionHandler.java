package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//ADD EXCEPTION HANDLING
	
		//ADD EXCEPTION HANDLER - STUDENT NOT FOUND
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
			
			//CREATE A STUDENTERRORRESPONSE
			StudentErrorResponse error = new StudentErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		//ADD ANOTHER EXCEPTION HANDLER - GENERIC 
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			
			//CREATE A STUDENTERRORRESPONSE
			StudentErrorResponse error = new StudentErrorResponse();
					
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			//THIS CAN BE CUSTOMIZE
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
					
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			
		}
	

}
