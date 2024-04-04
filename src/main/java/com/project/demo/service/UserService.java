package com.project.demo.service;

import com.project.demo.DTO.UserDTO;
import com.project.demo.exception.UserException;

public interface UserService {
	
	public UserDTO getUserDetails(Integer userId) throws UserException;
	
	public String addUser(UserDTO userDTO) throws UserException;
	
	public String updateUser(UserDTO userDTO) throws UserException;
	public String deleteUser(Integer userId) throws UserException;
	
	public UserDTO getUserDetailsByName(String userName) throws UserException;
	
	public UserDTO getUserDetailsPasswordAndCity(String city,String password) throws UserException;

}
