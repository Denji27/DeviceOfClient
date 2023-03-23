package net.primera.springboot.exception;

public class NotFoundException extends RuntimeException {
	

	public NotFoundException(String message) {
		super(message);
	}

}
