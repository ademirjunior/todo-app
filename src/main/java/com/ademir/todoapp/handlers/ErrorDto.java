package com.ademir.todoapp.handlers;

import java.util.ArrayList;
import java.util.List;

import com.ademir.todoapp.exception.ErrorCodes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Holds error code, error message and related error messages of an error")
public class ErrorDto {

	@ApiModelProperty(value = "The error code.", required = true)
	private Integer httpCode;

	@ApiModelProperty(value = "The error code.", required = true)
	private ErrorCodes code;

	@ApiModelProperty(value = "A detailed error message.")
	private String message;

	@ApiModelProperty(value = "The input fields related to the error, if any.")
	List<String> errors = new ArrayList<String>();

}
