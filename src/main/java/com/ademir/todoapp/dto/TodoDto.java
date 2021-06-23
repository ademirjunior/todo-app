package com.ademir.todoapp.dto;

import java.time.ZonedDateTime;

import com.ademir.todoapp.model.Todo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {

	private Long id;

	private String title;

	private String description;

	private ZonedDateTime startDate;
	
	private boolean done;
	
	private boolean favorite;
	
	private CategoryDto categoryDto;
	
	public static Todo toEntity (TodoDto todoDto) {
		final Todo todo = new Todo();
		todo.setId(todoDto.getId());
		todo.setTitle(todoDto.getTitle());
		todo.setDescription(todoDto.getDescription());
		todo.setDone(todoDto.isDone());
		todo.setFavorite(todoDto.isFavorite());
		todo.setStartDate(todoDto.getStartDate());
		todo.setCategory(CategoryDto.toEntity(todoDto.getCategoryDto()));
		
		return todo;
	}
	
	public static TodoDto fromEntity(Todo todo) {
		return TodoDto.builder()
				.id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .startDate(todo.getStartDate())
                .done(todo.isDone())
                .favorite(todo.isFavorite())
				.build();
	}
	
}
