package com.egiftcard1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.egiftcard1.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT cd from Customer cd where cd.email=?1")
	public Customer findByEmail(String email);
	
	public Customer findByEmailAndPassword(String email, String password);


}
