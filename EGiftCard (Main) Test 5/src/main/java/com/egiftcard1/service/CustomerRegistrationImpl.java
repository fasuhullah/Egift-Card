package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.CustomerRepository;
import com.egiftcard1.entity.Customer;



@Service
public class CustomerRegistrationImpl implements CustomerRegistration {
	
	@Autowired
	private CustomerRepository cusRepo;
	
	@Override
	public Customer RegisterUser(Customer cus) {
		return cusRepo.save(cus);
		
	}

	@Override
	public Customer retrieveCustomer(String email) {
		return cusRepo.findByEmail(email);
	}
	
	@Override
	public Optional<Customer> getCustomer(int cusid) {
		
		return cusRepo.findById(cusid);
	}
	
	@Override
	public Customer updateCustomer(Customer cus) {
		
		return cusRepo.save(cus);
	}

	@Override
	public String deleteCustomerById(int cusId) {
		
		cusRepo.deleteById(cusId);
		return "Customer deleted with Id : "+cusId;
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		
		return cusRepo.findAll();
	}
	
	@Override
	public Customer login(String email, String password){

		return cusRepo.findByEmailAndPassword(email, password);
		
	}
	
	@Override
	public String forgotPassword(String email) {
		
		Customer cus = (Customer) cusRepo.findByEmail(email);
		if(email.equals(cus.getEmail()))
		{
			return "Your Old Password is : "+cus.getPassword();
		}
		return "Not Valid User";
	}
	
	@Override
	public void customerLogout(int id) {
		System.exit(id);
		
	}

	public Customer getCustomerId(int id) {
		
		return cusRepo.getById(id);
	}


}
