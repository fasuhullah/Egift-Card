package com.egiftcard1.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.GiftRedeemDetails;



public interface GiftRedeemDao extends JpaRepository<GiftRedeemDetails, Integer> {

}
