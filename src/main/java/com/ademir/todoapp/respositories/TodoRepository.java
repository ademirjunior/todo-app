package com.ademir.todoapp.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.todoapp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findTodoByCategoryId(Long categoryId);
}
