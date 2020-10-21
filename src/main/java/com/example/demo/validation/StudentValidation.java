/**
 * 
 */
package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.StudentIdNotInScopeException;
import com.example.demo.exception.StudentNameNotInScopeExeption;
import com.example.demo.model.Student;
import com.example.demo.util.StudentUtil;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author duleepa_w
 *
 */
@Component
public class StudentValidation {

	@Autowired
	private StudentUtil studentUtil;
	
	public void paramValidation(Student studentRequest) {
		if(!(studentUtil.isNumber(studentRequest.getId()) && 
				studentUtil.idRange(studentRequest.getId()))) throw new StudentIdNotInScopeException();
		
		if(!studentUtil.nameScope(studentRequest.getName())) throw new StudentNameNotInScopeExeption();
	}
	
	public void validateJSON(String studentRequest) {
		try {
			JsonParser parser = new JsonParser();
			parser.parse(studentRequest);
		}catch (JsonSyntaxException e ) {
			e.printStackTrace();
		}
	}
}
