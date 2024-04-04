package com.project.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	Environment enviroment;
	
	@ExceptionHandler(Exception.class)
	public String expectionHandler(Exception e)
	{
		return enviroment.getProperty(e.getMessage());
	}

}
