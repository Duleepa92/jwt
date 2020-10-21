package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.UserDTO;
import com.example.demo.domain.UserDTOResponse;
import com.example.demo.model.DAOUser;

@Service
public interface JwtUserService {

	public DAOUser save(DAOUser user);
	public List<UserDTOResponse> getAllUsers();
	
}
