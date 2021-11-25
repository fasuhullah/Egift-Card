package com.egiftcard1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.PaymentDetails;
import com.egiftcard1.exception.PaymentDetailsException;
import com.egiftcard1.service.PaymentService;


@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payments")
	public List<PaymentDetails> getAllPaymentDetails() {
		return paymentService.getAllPaymentDetails();
	}

	@GetMapping("/payment/{id}")
	public PaymentDetails getPaymentDetailsById(@PathVariable("id") Integer id) throws PaymentDetailsException {

		PaymentDetails paymentDetails = null;
		paymentDetails = paymentService.getPaymentDetailsById(id);
		return paymentDetails;
	}

	@PostMapping("/payment")
	public PaymentDetails registerPaymentDetails(@RequestBody PaymentDetails paymentDetails) {
		return paymentService.registerPaymentDetails(paymentDetails);

	}

	@PutMapping("/payment")
	public PaymentDetails updatePaymentDetails(@Valid @RequestBody PaymentDetails paymentDetails,
			BindingResult bindingResult) throws PaymentDetailsException {
		StringBuilder errorMessage = new StringBuilder();
		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				errorMessage.append(error.getDefaultMessage());
			}
			throw new PaymentDetailsException(errorMessage.toString());
		}

		return paymentService.updatePaymentDetails(paymentDetails);
	}

	@PutMapping("/payment/{id}")
	public PaymentDetails updatePaymentDetailsById(@PathVariable("id") Integer id,
			@Validated @RequestBody PaymentDetails paymentDetails, BindingResult bindingResult)
			throws PaymentDetailsException {
		StringBuilder errorMessage = new StringBuilder();
		if (bindingResult.hasErrors()) {

			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				errorMessage.append(error.getDefaultMessage());
			}
			throw new PaymentDetailsException(errorMessage.toString());
		}

		return paymentService.updatePaymentDetailsById(id);

	}
	@DeleteMapping("/payment")
	public String deletePaymentDetails(PaymentDetails paymentDetails) {
		return paymentService.deletePaymentDetails(paymentDetails);
	}

	@DeleteMapping("/payment/{id}")
	public String deletePaymentDetailsById(@PathVariable("id") Integer paymentId) throws PaymentDetailsException {
		return paymentService.deletePaymentDetailsById(paymentId);
	}

}
