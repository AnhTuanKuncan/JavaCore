package com.example.demo.errors;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage(), (msg1, msg2) -> msg1));
		return ResponseEntity.badRequest().body(errors);

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNotFound(NoSuchElementException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleOther(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("error", "Lỗi hệ thống", "message", ex.getMessage()));
	}
}
