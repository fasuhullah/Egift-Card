package com.EGiftCard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.egiftcard1.dao.PaymentDao;
import com.egiftcard1.entity.PaymentDetails;
import com.egiftcard1.exception.PaymentDetailsException;
import com.egiftcard1.service.PaymentServiceImpl;



@ExtendWith(SpringExtension.class)
public class PaymentDetailsTestImpl {
	
	@InjectMocks
	PaymentServiceImpl paySer;
	
	@MockBean
	PaymentDao paymentDao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testRegisterPaymentdetails() {
		PaymentDetails pay = new PaymentDetails(100,"24NOV21",5000.0f, "Alexander", "4123456789123456", "10/21", "288");
		Mockito.when(paymentDao.save(pay)).thenReturn(pay);
		PaymentDetails persistedpay = paySer.registerPaymentDetails(pay);
		assertEquals(pay, persistedpay);
	}
	
	@Test
	void testGetPaymentDetails() throws PaymentDetailsException {
		PaymentDetails pay = new PaymentDetails(100,"24NOV21",5000.0f, "Alexander", "4123456789123456", "10/21", "288");
		Mockito.when(paymentDao.findById(100)).thenReturn(Optional.of(pay));
		PaymentDetails persistedpay = paySer.getPaymentDetailsById(pay.getPaymentId());
		assertEquals(pay, persistedpay);
	}
	@Test
	void testPaymentDetailsByIdException() {
		assertThrows(PaymentDetailsException.class,()-> paySer.getPaymentDetailsById(102)  );
	}
	
	@Test
	void testUpdatePaymentDetailsByIdException() {
		assertThrows(PaymentDetailsException.class,()-> paySer.updatePaymentDetailsById(102)  );
	}
	
	@Test
	void testDeletePaymentDetailsByIdException() {
		assertThrows(PaymentDetailsException.class,()-> paySer.deletePaymentDetailsById(102)  );
	}
	
	@Test
	void testUpdatePaymentdetails() {
		PaymentDetails pay = new PaymentDetails(100,"24NOV21",5000.0f, "Alexander", "4123456789123456", "10/21", "288");
		Mockito.when(paymentDao.save(pay)).thenReturn(pay);
		PaymentDetails persistedpay = paySer.updatePaymentDetails(pay);
		assertEquals(pay, persistedpay);
	}
	@Test
	void testDeletePaymentdetails() {
		PaymentDetails pay = new PaymentDetails(100,"24NOV21",5000.0f, "Alexander", "4123456789123456", "10/21", "288");
		Mockito.when(paymentDao.save(pay)).thenReturn(pay);
		String persistedpay = paySer.deletePaymentDetails(pay);
		assertEquals(pay,persistedpay);
	}
	
	@Test
	void testGetAllPaymentdetails() {
		PaymentDetails pay1 = new PaymentDetails(100,"24NOV21",5000.0f, "Alexander", "4123456789123456", "10/21", "288");
		PaymentDetails pay2 = new PaymentDetails(101,"24NOV21",5000.0f, "Sikander", "4123456789123466", "10/21", "288");
		List<PaymentDetails> pd = new ArrayList<PaymentDetails>();
		pd.add(pay1); pd.add(pay2);
		Mockito.when(paymentDao.saveAll(pd)).thenReturn(pd);
		List <PaymentDetails> persistedpay = (List<PaymentDetails>) paySer.getAllPaymentDetails();
		assertArrayEquals(pd, persistedpay);
	}

	private void assertArrayEquals(List<PaymentDetails> pd, List<PaymentDetails> persistedpay) {
		
	}

	
	

	

	
	
	

}
