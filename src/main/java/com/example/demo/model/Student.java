/**
 * 
 */
package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

/**
 * @author duleepa_w
 *
 */

@Component
public class Student {
	
	@NotNull
	@Min(5)
	@Max(20)
	@NumberFormat
	private String id;
	
	@Size(min = 10 , max = 50)
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
