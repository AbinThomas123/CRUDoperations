package com.project.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.DTO.UserDTO;
import com.project.demo.entity.User;
import com.project.demo.repository.UserRepository;

import jakarta.transaction.Transactional;


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
	
	@Transactional
	@Override
	public String addUser(UserDTO userDTO) {
	
		User user=new User();
		user.setCity(userDTO.getCity());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		
		userRepository.save(user);
		
		return "Sucess";
	}
	
	@Transactional
	@Override
	public String updateUser(UserDTO userDTO) {
		
	Optional<User> optional	=userRepository.findById(userDTO.getUserId());
	
		User user=optional.get();
		
		user.setCity(userDTO.getCity());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		
		
		return "Success";
	}
	
	@Transactional
	@Override
	public String deleteUser(Integer userId) {
		
	userRepository.deleteById(userId);
	
	return "Success";
		
	}

	@Override
	public UserDTO getUserDetailsByName(String userName) {
	
		User user =userRepository.findByUserName(userName);
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setCity(user.getCity());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserId(user.getUserId());
		return userDTO;
	}

	@Override
	public UserDTO getUserDetailsPasswordAndCity(String city, String password) {
		
		User user =userRepository.findByPasswordAndCity(city,password);
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setCity(user.getCity());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserId(user.getUserId());
		return userDTO;
	}

}
