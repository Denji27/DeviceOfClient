package net.primera.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlerNotFoundException(NotFoundException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	}
	
	@ExceptionHandler(DuplicateRecordException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handlerDuplicateRecordException(DuplicateRecordException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
	}
}
