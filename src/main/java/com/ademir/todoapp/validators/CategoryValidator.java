package com.ademir.todoapp.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.ademir.todoapp.dto.CategoryDto;

public class CategoryValidator {

	public static List<String> validateCategory(CategoryDto categoryDto) {
		
        List<String> errors = new ArrayList<String>();
        
        if (categoryDto == null) {
            errors.add("Please fill the name");
            errors.add("Please fill the description");
            return  errors;
        }
        if (StringUtils.hasText(categoryDto.getName())) {
            errors.add("Please fill the name");
        }
        if (StringUtils.hasText(categoryDto.getDescription())) {
            errors.add("Please fill the description");
        }
        
        return errors;
    }
}
