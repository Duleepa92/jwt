/**
 * 
 */
package com.example.demo.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

/**
 * @author duleepa_w
 *
 */

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final String SUCCESS = "Student is Saved successfully";
	private static final String SAVE_ERROR = "Studenet is not Save";
	private static final String UPDATE = "Student is Updated successfully";
	private static final String UPDATE_ERROR = "Student is not Update";
	
	private static Map<String , Student> studentRepo = new HashMap<String, Student>();
	
	static {		
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("Duleepa");
		studentRepo.put(s1.getId(), s1);
		
		Student s2 = new Student();
		s2.setId("2");
		s2.setName("Lahiru");
		studentRepo.put(s2.getId(), s2);
		
		
	}

	@Override
	public Map<String, Student> getStudents() {
		return studentRepo;
	}

	@Override
	public String createStudent(Student student) {
		try {
			studentRepo.put(student.getId(), student);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return SAVE_ERROR;
		}
		
	}

	@Override
	public String updateStudent(String id, Student student) {
		try {
			studentRepo.remove(id);
			student.setId(id);
			studentRepo.put(id, student);
			return UPDATE;
		}catch(Exception e) {
			e.printStackTrace();
			return UPDATE_ERROR;
		}
	}
	
	
}
