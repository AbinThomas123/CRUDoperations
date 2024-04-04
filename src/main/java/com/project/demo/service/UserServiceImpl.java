package com.project.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.DTO.UserDTO;
import com.project.demo.entity.User;
import com.project.demo.exception.UserException;
import com.project.demo.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO getUserDetails(Integer userId)throws UserException {
		
	Optional<User> user	=userRepository.findById(userId);
	if(user.isEmpty())
	{
		throw new UserException("SERVICE.USER.NOT.FOUND");
	}
	
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
	public String addUser(UserDTO userDTO)throws UserException {
		
		Optional<User> optional=userRepository.findById(userDTO.getUserId());
		if(optional.isPresent())
		{
			throw new  UserException("SERVICE.USER.ALREADY.EXISTS");
		}
	
		User user=new User();
		user.setCity(userDTO.getCity());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		
		userRepository.save(user);
		
		return userDTO.getUserName();
	}
	
	@Transactional
	@Override
	public String updateUser(UserDTO userDTO) throws UserException{
		
	Optional<User> optional	=userRepository.findById(userDTO.getUserId());
	
		User user=optional.get();
		
		user.setCity(userDTO.getCity());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNo(userDTO.getPhoneNo());
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		
		
		return userDTO.getUserName();
	}
	
	@Transactional
	@Override
	public String deleteUser(Integer userId)throws UserException {
		
	Optional<User> user	=userRepository.findById(userId);
	if(user.isEmpty())
	{
		throw new UserException("SERVICE.USER.NOT.FOUND");
	}
		
	userRepository.deleteById(userId);
	
	return user.get().getUserName();
		
	}

	@Override
	public UserDTO getUserDetailsByName(String userName)throws UserException {
	
		User user =userRepository.findByUserName(userName);
		if(user==null)
		{
			throw new UserException("SERVICE.USER.NOT.FOUND");
		}
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setCity(user.getCity());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserId(user.getUserId());
		return userDTO;
	}

	@Override
	public UserDTO getUserDetailsPasswordAndCity(String city, String password)throws UserException {
		
		User user =userRepository.findByPasswordAndCity(city,password);
		
		if(user==null)
		{
			throw new UserException("SERVICE.USER.NOT.FOUND");
		}
		
		UserDTO userDTO=new UserDTO();
		
		userDTO.setCity(user.getCity());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserId(user.getUserId());
		return userDTO;
	}

}
