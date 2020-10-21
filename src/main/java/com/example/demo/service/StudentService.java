/**
 * 
 */
package com.example.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

/**
 * @author duleepa_w
 *
 */
@Service
public interface StudentService {

	public Map<String , Student> getStudents();
	public String createStudent(Student student);
	public String updateStudent(String id , Student student);
}
