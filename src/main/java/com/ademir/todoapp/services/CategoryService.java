package com.ademir.todoapp.services;

import java.util.List;

import com.ademir.todoapp.dto.CategoryDto;

public interface CategoryService {

	CategoryDto save(CategoryDto category);

	List<CategoryDto> findAll();

	CategoryDto findById(Long id);

	List<CategoryDto> findAllByUserId(Long userId);

	void delete(Long id);

	List<CategoryDto> getAllTodoByCategoriesForToday(Long userId);

}
