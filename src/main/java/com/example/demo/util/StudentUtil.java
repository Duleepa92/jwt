package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

	public boolean isNumber(String parm) {
		if(parm.matches("^[0-9]*$")) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean idRange(String parm) {
		if(parm.matches("([5-9]|1[0-9]|20)")) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean nameScope(String parm) {
		int length = parm.length();
		if(length < 50 && length > 10) {
			return true;
		}else {
			return false;
		}
	}
}
