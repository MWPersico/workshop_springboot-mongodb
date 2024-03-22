package com.marcprojects.workshopmongo.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcprojects.workshopmongo.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// Extrema importância, tratamento personalizado para exceções
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request){
		String errorMessage = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(),status.value(), errorMessage, ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	/*
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException ex, HttpServletRequest request){
		String errorMessage = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(Instant.now(),status.value(), errorMessage, ex.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	*/
}
