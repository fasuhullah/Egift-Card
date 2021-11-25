package com.egiftcard1.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.egiftcard1.exception.PaymentDetailsException;




@RestControllerAdvice
public class PaymentControllerAdvice {
	
	@ExceptionHandler(value = { PaymentDetailsException.class })
	public ResponseEntity<String> paymentDetailsException(Exception e){
		
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		
		
	}
	
}
