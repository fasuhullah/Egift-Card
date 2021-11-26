package com.egiftcard1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.GiftCard;

public interface GiftCardDao  extends JpaRepository<GiftCard, Integer> {
	

}
