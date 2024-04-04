package com.project.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.demo.entity.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	public User findByUserName(String userName);
	

}
