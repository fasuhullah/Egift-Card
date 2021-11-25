package com.egiftcard1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.egiftcard1.exception.InsufficientBalanceException;
import com.egiftcard1.exception.InvalidCustomerIdException;

@RestControllerAdvice
public class NotificationControllerAdvice {

	@ExceptionHandler(value = { InsufficientBalanceException.class })
	// @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> insufficientbalanceException(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = { InvalidCustomerIdException.class })
	// @ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<String> invalidCustomerIdException(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

	}
}
