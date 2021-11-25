package com.egiftcard1.exception;

public class InvalidCustomerIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidCustomerIdException() {
		super();
	}
	
	public InvalidCustomerIdException(String message) {
		super(message);
	}
}
