package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.PaymentDao;
import com.egiftcard1.entity.PaymentDetails;
import com.egiftcard1.exception.PaymentDetailsException;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentDao paymentDao;

	
		
	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		return paymentDao.findAll();
	}

	@Override
	public PaymentDetails getPaymentDetailsById(Integer paymentId) throws PaymentDetailsException  {
		Optional<PaymentDetails> paymentOptional = paymentDao.findById(paymentId);
		if (paymentOptional.isEmpty())
			throw new PaymentDetailsException("Payment_Details not found with given paymentId");
		return paymentOptional.get();
	}

	@Override
	public PaymentDetails registerPaymentDetails(PaymentDetails paymentDetails) {
		return paymentDao.save(paymentDetails);
	}


	@Override
	public PaymentDetails updatePaymentDetails(PaymentDetails paymentDetails) {
		return paymentDao.save(paymentDetails);
	}

	@Override
	public PaymentDetails updatePaymentDetailsById(Integer paymentId) throws PaymentDetailsException    {
		Optional<PaymentDetails> paymentOptional = paymentDao.findById(paymentId);
		
		if(paymentOptional.isPresent()) {
			return paymentOptional.get();
		}
		else {
			throw new PaymentDetailsException("Payment_Details Not Found");
		}
		
	}

	@Override
	public String deletePaymentDetails(PaymentDetails paymentDetails) {
		paymentDao.delete(paymentDetails);
		return "All payment details are deleted from Database" ;
	}

	@Override
	public String deletePaymentDetailsById(Integer paymentId) throws PaymentDetailsException {
		Optional<PaymentDetails> deletePaymentDetails = paymentDao.findById(paymentId);
		if(deletePaymentDetails.isPresent()) {
			paymentDao.delete(deletePaymentDetails.get());
			return "Payment Details with payment Id :"+paymentId+" is deleted";
		}else
			throw new PaymentDetailsException("Wallet could not found to be deleted in this paymentId");
		
		
	}

	

}
