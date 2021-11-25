package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import com.egiftcard1.entity.Customer;

public interface CustomerRegistration {

	public Customer RegisterUser(Customer cus);

	public Customer retrieveCustomer(String email);

	public Optional<Customer> getCustomer(int cusid);

	public Customer updateCustomer(Customer cus);

	public String deleteCustomerById(int cusId);

	public List<Customer> getAllCustomers();

	public Customer login(String email, String password);

	public String forgotPassword(String email);

	public void customerLogout(int id);
	
	public Customer getCustomerId(int id);
}
