package com.tyss.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.exception.UserNotFoundException;
import com.tyss.response.SucessResponse;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<SucessResponse> userNotFoundException(UserNotFoundException exception){
		return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message(exception.getMessage()).data(exception).build());
	}

}
