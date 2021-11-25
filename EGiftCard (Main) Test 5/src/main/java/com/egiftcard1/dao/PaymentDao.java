package com.egiftcard1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.PaymentDetails;
public interface PaymentDao extends JpaRepository<PaymentDetails, Integer> {

} 
