/**
 * 
 */
package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.validation.StudentValidation;

/**
 * @author duleepa_w
 *
 */

@RestController
public class DemoController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentValidation studentValidation;
	
	@RequestMapping( value = "/getStudent", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents(){		
		return new ResponseEntity<>(studentService.getStudents().values() , HttpStatus.OK);
	}
	 
	@RequestMapping( value = "/student" , method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student studentRequest){
		String result = studentService.createStudent(studentRequest);
		return new ResponseEntity<>(result , HttpStatus.CREATED);
	}
	
	@RequestMapping( value = "/updateStudent/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id , @RequestBody Student student){
		studentValidation.paramValidation(student);
		studentValidation.validateJSON(student.toString());
		String result = studentService.updateStudent(id, student);
		return new ResponseEntity<>(result , HttpStatus.OK);
	}
	
}
