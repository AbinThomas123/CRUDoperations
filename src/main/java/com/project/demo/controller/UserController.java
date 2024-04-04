package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.DTO.UserDTO;
import com.project.demo.exception.UserException;
import com.project.demo.service.UserService;
@RestController

@RequestMapping("/user/")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	//@RequestMapping(value="{userId}",method= RequestMethod.GET)
	
	@GetMapping("{userId}")
	public UserDTO getUserDetails(@PathVariable  Integer userId)throws UserException
	{
		return userService.getUserDetails(userId);
		
	}
	
	//@RequestMapping(value="new",method=RequestMethod.POST)
	@PostMapping("new")
	public String addUser(@RequestBody  UserDTO userDTO)throws UserException
	{
		return userService.addUser(userDTO);
	}
	@PutMapping("update")
	public String updateUser(@RequestBody  UserDTO userDTO)throws UserException
	{
		return userService.updateUser(userDTO);
	}
	
	@DeleteMapping("delete/{userId}")
	public String deleteUser(@PathVariable  Integer userId)throws UserException
	{
		return userService.deleteUser(userId);
		
	}
	
	@GetMapping("name/{userName}")
	public UserDTO getUserDetailsByName(@PathVariable String userName)throws UserException
	{
		return userService.getUserDetailsByName(userName);
	}
	
	@GetMapping("{password}/{city}")
	public UserDTO findByPasswordAndCity(@PathVariable String city,@PathVariable String password)throws UserException
	{
		return userService.getUserDetailsPasswordAndCity(city,password);
	}

}
