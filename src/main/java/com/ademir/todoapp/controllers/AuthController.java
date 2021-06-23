package com.ademir.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ademir.todoapp.controllers.api.AuthApi;
import com.ademir.todoapp.dto.UserDto;
import com.ademir.todoapp.services.UserService;

public class AuthController implements AuthApi {

	@Autowired
    private UserService userService;
	
	@Override
	public ResponseEntity<UserDto> loginUser(UserDto user) {
		return new ResponseEntity<UserDto>(userService.login(user), HttpStatus.OK);
	}

}
