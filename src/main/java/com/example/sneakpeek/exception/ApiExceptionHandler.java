package com.example.sneakpeek.exception;

import java.time.ZonedDateTime;

import javax.naming.directory.InvalidAttributeValueException;

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
	
	@ExceptionHandler(value = InvalidAttributeValueException.class)
	public ResponseEntity<Object> handleInvalidAttributeValueExceptionException(InvalidAttributeValueException e){
		
		ApiException exception = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
