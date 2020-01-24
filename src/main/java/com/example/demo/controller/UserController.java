package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	private static final String ENDPOINT = "/user";
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="Create User")
	@PostMapping(value = ENDPOINT,
	             consumes = MediaType.APPLICATION_JSON_VALUE,
	             produces = MediaType.APPLICATION_JSON_VALUE )
	public User createUser(@RequestBody UserDto userDto, HttpServletRequest httpSevletRequest) {
		User user = userService.createUser(userDto);
		return user;
	}
}
