package com.ademir.todoapp.services;

import java.util.List;

import com.ademir.todoapp.dto.TodoDto;

public interface TodoService {

	TodoDto save(TodoDto todoDto);

    List<TodoDto> findAll();

    TodoDto findById(Long id);

    List<TodoDto> findByCategory(Long categoryId);

    void delete(Long id);
    
}
