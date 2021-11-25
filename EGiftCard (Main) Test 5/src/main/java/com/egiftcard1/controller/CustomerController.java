package com.egiftcard1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.Customer;
import com.egiftcard1.exception.DuplicateCustomerException;
import com.egiftcard1.exception.InvalidCredentialException;
import com.egiftcard1.exception.InvalidCustomerIdException;
import com.egiftcard1.service.CustomerRegistration;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRegistration cusSerImpl; // CustomerRegistration ref1 = new CustomerRegistration(); 
	
	@PostMapping("/api/register")
	public Customer registerCustomer(@Valid @RequestBody Customer newcus) throws DuplicateCustomerException
	{
		String tempEmailId = newcus.getEmail();
		Customer cus = null;
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Customer cus1 = cusSerImpl.retrieveCustomer(tempEmailId); 
			if(cus1 != null)
			{
				throw new DuplicateCustomerException("User with "+tempEmailId+" is already exists");
			}
		}
		cus = cusSerImpl.RegisterUser(newcus);
		return cus;
	}
	
	@RequestMapping(value= "/api/{id}", method= RequestMethod.GET)
    public Customer getCustomer(@PathVariable int id) 
	{
        Optional<Customer> cus =  cusSerImpl.getCustomer(id);
        if(!cus.isPresent())
        {
             return new Customer();         // returns empty Customer object
        }
        else
            return cus.get();              // returns Customer object with data
    }
	
	@PutMapping("/api/update")
	public Customer updateCustomer(@Valid @RequestBody Customer updcus)
	{
		return cusSerImpl.updateCustomer(updcus);
	}
	
	@PutMapping("/api/update/{cusId}")
	public Customer updateCustomerById(@PathVariable int cusId, @Valid @RequestBody Customer updcus) throws InvalidCustomerIdException{
		Customer cus = null;
		if(cusId != 0 && cusId >0) {
			Optional<Customer> cus1 = cusSerImpl.getCustomer(cusId);
			if(!cus1.isPresent()) {
				throw new InvalidCustomerIdException("Provided CustomerId "+cusId+" not a Valid Customer");
			}
			else {
				cus = cusSerImpl.updateCustomer(updcus);
				return cus;
			}
		}
		else {
			return new Customer();
		}
	}
	
	@RequestMapping(value= "/api/delete/{cusId}", method= RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable int cusId) {

	        Optional<Customer> cus =  cusSerImpl.getCustomer(cusId);
	        if(!cus.isPresent())
	                return "Could not find customer with id - " + cusId;
	        else   
	        	return cusSerImpl.deleteCustomerById(cusId);
	}
	
	@RequestMapping(value = "/api/all", method = RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		return cusSerImpl.getAllCustomers();
	}
	
	@PostMapping("/api/login")
	public Customer Login(@Valid @RequestBody Customer cus) throws InvalidCredentialException
	{
		String tempEmailId = cus.getEmail();
		String tempPass    = cus.getPassword();
		Customer customer = null;
		if(tempEmailId != null && tempPass != null)
		{
			customer = cusSerImpl.login(tempEmailId, tempPass);
		}
		if(customer == null)
		{
			throw new InvalidCredentialException("Failed to Login");
		}
		return customer;
	}
	
	@PutMapping("api/changepswd")
	public Customer ChangePassword(@Valid @RequestBody Customer updcus) {
		return cusSerImpl.updateCustomer(updcus);
	}
	
	@GetMapping("/api/forgotpswd/{email}")
	public String ForgotPassWord(@PathVariable String email)
	{
		String forgotpswd = cusSerImpl.forgotPassword(email);
		return forgotpswd;
	}
	
	@GetMapping("/api/logout/{id}")
	public void customerLogout(@PathVariable int id) {
		cusSerImpl.customerLogout(id);
	}
	
}
