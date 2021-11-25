package com.EGiftCard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.egiftcard1.dao.CustomerRepository;
import com.egiftcard1.entity.Customer;
import com.egiftcard1.entity.Login;
import com.egiftcard1.service.CustomerRegistrationImpl;



@ExtendWith(SpringExtension.class)
class CustomerModuleImplTest {
	
	@InjectMocks 
	CustomerRegistrationImpl cusSer;
	
	@MockBean 
	CustomerRepository cusRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);//close resource test
	}
	
	@Test
	void testRegisterCustomer()
	{
		Customer cus = new Customer(102,"Karan","Eswar","Karan@gmail.com","12345","7980878667","PTR");
		Mockito.when(cusRepo.save(cus)).thenReturn(cus);
		Customer persistedlog = cusSer.RegisterUser(cus);
		assertEquals(cus,persistedlog);	
	}
	
	@Test
	void testChangePassword()
	{
		Customer cus = new Customer(101,"Parvathi","Eswar","Parvathi@gmail.com","1234","7980878675","TPT");
		Mockito.when(cusRepo.findByEmail("Parvathi@gmail.com")).thenReturn(cus);
		cus.setPassword("123");
		Mockito.when(cusRepo.save(cus)).thenReturn(cus);
		Login log = new Login("Parvathi@gmail.com","1234","CUSTOMER");
		Customer persistedlog = cusSer.updateCustomer(cus);
		assertEquals(cus, persistedlog);
	}
	
	@Test
	void testForgotPassword()
	{
		Customer cus = new Customer(101,"Sai","Eswar","Sai@gmail.com","1234","7980878675","TPT");
		Mockito.when(cusRepo.findByEmail("Sai@gmail.com")).thenReturn(cus);
		String persistedlog = cusSer.forgotPassword(cus.getEmail());
		assertEquals("Your Old Password is : "+cus.getPassword(), persistedlog.toString());
	}
	
	@Test
	void testUpdateCustomer()
	{
		Customer cus = new Customer(102,"Chery","Eswar","Chery@gmail.com","7980878675","1234","TPT");
		Mockito.when(cusRepo.findById(102)).thenReturn(Optional.of(cus));
		cus.setPassword("123");		
		Mockito.when(cusRepo.save(cus)).thenReturn(cus);
		Customer persistedcus = cusSer.updateCustomer(cus);
		assertEquals(102,persistedcus.getCustomerId());
		assertEquals("Chery",persistedcus.getFirstName());
		assertEquals("Eswar",persistedcus.getLastName());
		assertEquals("Chery@gmail.com",persistedcus.getEmail());
		assertEquals("123",persistedcus.getPassword());
		assertEquals("7980878675",persistedcus.getMobile());
	}
	
	@Test
	void getCustomer()
	{
		Customer cus = new Customer(102,"Chery","Eswar","Chery@gmail.com","7980878675","1234","TPT");
		Mockito.when(cusRepo.findById(102)).thenReturn(Optional.of(cus));
		Optional<Customer> persistedcus = cusSer.getCustomer(cus.getCustomerId());
		assertEquals(cus,persistedcus.get());
		
	}
	
	@Test
	void Login() {
		Customer cus = new Customer(102,"Chery","Eswar","Chery@gmail.com","7980878675","1234","TPT");
		String tempEmail = cus.getEmail();
		String tempPswd = cus.getPassword();
		Mockito.when(cusRepo.findByEmailAndPassword(tempEmail, tempPswd)).thenReturn(cus);
		Customer persistedcus = cusSer.login("Chery@gmail.com", "1234");
		assertEquals(102,persistedcus.getCustomerId());
		assertEquals("Chery",persistedcus.getFirstName());
		assertEquals("Eswar",persistedcus.getLastName());
		assertEquals("Chery@gmail.com",persistedcus.getEmail());
		assertEquals("1234",persistedcus.getPassword());
		assertEquals("7980878675",persistedcus.getMobile());
	}
}
