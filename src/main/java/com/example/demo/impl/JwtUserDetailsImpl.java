/**
 * 
 */
package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserDTOResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.DAOUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JwtUserService;

/**
 * @author duleepa_w
 *
 */

@Service
public class JwtUserDetailsImpl implements UserDetailsService , JwtUserService{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DAOUser user = userRepo.findByUsername(username);

		if (!username.isEmpty()) {

			return new User(user.getUsername(), user.getPassword(), new ArrayList<>());

		} else {
			throw new UsernameNotFoundException("User Not found");
		}

	}

	public DAOUser save(DAOUser user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(newUser);
	}
	
	 public List<UserDTOResponse> getAllUsers() {
	        List<DAOUser> users = new ArrayList<DAOUser>();
	        userRepo.findAll().forEach(user -> users.add(user));
	        List<UserDTOResponse> userDtoList = userMapper.convertToUserDTO(users);
	        return userDtoList;
	  }

}
