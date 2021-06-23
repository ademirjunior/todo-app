package com.ademir.todoapp.controllers.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ademir.todoapp.dto.UserDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.ademir.todoapp.utils.Constants.APP_ROOT;

@Api("authApi")
public interface AuthApi {

	@ApiOperation(value = "Login User", notes = "Creates a new user", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "The conected user.")
	})
	@PostMapping(value = APP_ROOT + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<UserDto> loginUser(@ApiParam (value = "User Dto", required = true) @RequestBody UserDto user);
}
