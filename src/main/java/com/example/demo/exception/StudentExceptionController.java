/**
 * 
 */
package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author duleepa_w
 *
 */
@ControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler( value = StudentIdNotInScopeException.class)
	public ResponseEntity<Object> exception(StudentIdNotInScopeException exception){
		 return new ResponseEntity<>("ID is not in Scope", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler( value = StudentNameNotInScopeExeption.class)
	public ResponseEntity<Object> exception(StudentNameNotInScopeExeption exception){
		return new ResponseEntity<Object>("Name is Not in Scope" , HttpStatus.NOT_ACCEPTABLE);		
	}
	
	@ExceptionHandler( value = StudentInvalidJsonException.class)
	public ResponseEntity<Object> exception(StudentInvalidJsonException exception){
		return new ResponseEntity<Object>("Invalid Student JSON" , HttpStatus.NOT_ACCEPTABLE);		
	}
}
