package com.project.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.DTO.UserDTO;
import com.project.demo.entity.User;
import com.project.demo.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO getUserDetails(Integer userId) {
		
	Optional<User> user	=userRepository.findById(userId);
	
	User userEntity= user.get();
	UserDTO userDTO=new UserDTO();
	userDTO.setCity(userEntity.getCity());
	userDTO.setPassword(userEntity.getPassword());
	userDTO.setPhoneNo(userEntity.getPhoneNo());
	userDTO.setUserName(userEntity.getUserName());
	userDTO.setUserId(userEntity.getUserId());
		
		return userDTO;
	}

}
