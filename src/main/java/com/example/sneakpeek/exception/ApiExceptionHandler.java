package com.example.sneakpeek.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = SecurityException.class)
	public ResponseEntity<Object> handleSecurityException(SecurityException e) {

		ApiException exception = new ApiException(e.getMessage(), HttpStatus.FORBIDDEN, ZonedDateTime.now());

		return new ResponseEntity<>(exception, HttpStatus.FORBIDDEN);
	}
}
