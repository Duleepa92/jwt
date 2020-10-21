/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.UserDTO;
import com.example.demo.domain.UserDTOResponse;
import com.example.demo.model.DAOUser;
import com.example.demo.util.ObjectMapperUtils;

/**
 * @author duleepa_w
 *
 */
@Component
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	public DAOUser convertTOEntity(UserDTO usreDTO) {		
		DAOUser daoUser = modelMapper.map(usreDTO , DAOUser.class);
		return daoUser;
	}
	
	@SuppressWarnings("static-access")
	public List<UserDTOResponse> convertToUserDTO(List<DAOUser> users){
		
		List<UserDTOResponse> listOfPostDTO = objectMapperUtils.mapAll(users, UserDTOResponse.class);
		return listOfPostDTO;
		
	}
	
}
