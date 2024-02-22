package com.datasystem.bookservice.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
