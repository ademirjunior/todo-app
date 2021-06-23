package com.ademir.todoapp.validators;

import java.util.ArrayList;
import java.util.List;

import com.ademir.todoapp.dto.TodoDto;

public class TodoValidator {

	public static List<String> validateTodo(TodoDto todoDto) {
		
		List<String> errors = new ArrayList<String>();
		
		if (todoDto == null) {
			errors.add("Please fill the title");
			errors.add("Please fill the description");
			errors.add("Please select a category");
			return errors;
		}
		if (todoDto.getTitle() == null || todoDto.getTitle().isBlank()) {
			errors.add("Please fill the title");
		}
		if (todoDto.getDescription() == null || todoDto.getDescription().isBlank()) {
			errors.add("Please fill the description");
		}
		if (todoDto.getCategoryDto() == null || todoDto.getCategoryDto().getId() == null) {
			errors.add("Please select a category");
		}
		
		return errors;
	}
}
