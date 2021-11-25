package com.egiftcard1.service;
import java.util.List;

import com.egiftcard1.entity.PaymentDetails;
import com.egiftcard1.exception.PaymentDetailsException;

public interface PaymentService {
	
	PaymentDetails registerPaymentDetails(PaymentDetails paymentDetails); //post
	
	List<PaymentDetails> getAllPaymentDetails();  //get
	
	PaymentDetails getPaymentDetailsById(Integer paymentId) throws PaymentDetailsException; //get id
	
	
	
	PaymentDetails updatePaymentDetails(PaymentDetails paymentDetails);   //put
	
	PaymentDetails updatePaymentDetailsById(Integer paymentId) throws PaymentDetailsException;    //put id
	
	String deletePaymentDetails(PaymentDetails paymentDetails);   //delete 
	
	String deletePaymentDetailsById(Integer paymentId) throws PaymentDetailsException;        //delete id


}