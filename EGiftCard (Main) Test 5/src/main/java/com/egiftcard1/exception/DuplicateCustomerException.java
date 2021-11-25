package com.egiftcard1.exception;

public class DuplicateCustomerException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DuplicateCustomerException() {
		super();

	}

	public DuplicateCustomerException(String message) {
		super(message);
	}
	
	

}