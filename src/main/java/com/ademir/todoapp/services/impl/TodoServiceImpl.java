package com.ademir.todoapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.todoapp.dto.CategoryDto;
import com.ademir.todoapp.dto.TodoDto;
import com.ademir.todoapp.exception.EntityNotFoundException;
import com.ademir.todoapp.exception.ErrorCodes;
import com.ademir.todoapp.exception.InvalidEntityException;
import com.ademir.todoapp.model.Category;
import com.ademir.todoapp.model.Todo;
import com.ademir.todoapp.respositories.CategoryRepository;
import com.ademir.todoapp.respositories.TodoRepository;
import com.ademir.todoapp.services.TodoService;
import com.ademir.todoapp.validators.TodoValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService {

	@Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
	@Override
	public TodoDto save(TodoDto todoDto) {
		List<String> errors = TodoValidator.validateTodo(todoDto);
        if (!errors.isEmpty()) {
            log.error("Todo is not valid {}", todoDto);
            throw new InvalidEntityException("Todo is not valid", ErrorCodes.TODO_NOT_VALID, errors);
        }
        return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todoDto)));
	}

	@Override
	public List<TodoDto> findAll() {
		return todoRepository.findAll().stream()
                .map(TodoDto::fromEntity)
                .collect(Collectors.toList());
	}

	@Override
	public TodoDto findById(Long id) {
		if (id == null) {
			log.error("User id is null");
			return null;
		}

		final Long categoryId = categoryRepository.findCategoryByTodoId(id);
		Category category = new Category();
		category.setId(categoryId);

		final Optional<Todo> todo = todoRepository.findById(id);
		todo.ifPresent(value -> value.setCategory(category));

		final TodoDto todoDto = TodoDto.fromEntity(todo.get());
		CategoryDto categoryDto = CategoryDto.fromEntity(category);
		todoDto.setCategoryDto(categoryDto);

		return Optional.of(todoDto).orElseThrow(
				() -> new EntityNotFoundException("No Todo found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
	}

	@Override
	public List<TodoDto> findByCategory(Long categoryId) {
		return todoRepository.findTodoByCategoryId(categoryId)
				.stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			log.error("Todo id is null");
			return;
		}
		todoRepository.deleteById(id);
	}

}
