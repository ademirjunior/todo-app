package com.ademir.todoapp.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.ademir.todoapp.dto.UserDto;

public class UserValidator {

	public static List<String> validateUser(UserDto user) {
		
        List<String> errors = new ArrayList<>();
        
        if (user == null) {
            errors.add("Please fill the First name");
            errors.add("Please fill the Last name");
            errors.add("Please fill the User name");
            errors.add("Please fill the user Email");
            errors.add("Please fill the User Password");
            return errors;
        }

        if (StringUtils.hasText(user.getFirstName())) {
            errors.add("Please fill the First name");
        }
        if (StringUtils.hasText(user.getLastName())) {
            errors.add("Please fill the Last name");
        }
        if (StringUtils.hasText(user.getUserName())) {
            errors.add("Please fill the User name");
        }
        if (StringUtils.hasText(user.getEmail())) {
            errors.add("Please fill the user Email");
        }
        if (StringUtils.hasText(user.getPassword())) {
            errors.add("Please fill the User Password");
        }

        return errors;
    }

    public static List<String> validateUserCredentials(String email, String password) {
    	
        List<String> errors = new ArrayList<String>();
        
        if (StringUtils.hasText(email)) {
            errors.add("Email is empty");
        }
        if (StringUtils.hasText(password)) {
            errors.add("Password is empty");
        }
        
        return errors;
    }
}
