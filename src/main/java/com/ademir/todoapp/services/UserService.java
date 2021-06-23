package com.ademir.todoapp.services;

import java.util.List;

import com.ademir.todoapp.dto.UserDto;

public interface UserService {

	UserDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);

    UserDto login(UserDto user);
}
