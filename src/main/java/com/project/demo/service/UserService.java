package com.project.demo.service;

import com.project.demo.DTO.UserDTO;

public interface UserService {
	
	public UserDTO getUserDetails(Integer userId);
	
	public String addUser(UserDTO userDTO);
	
	public String updateUser(UserDTO userDTO);

}
