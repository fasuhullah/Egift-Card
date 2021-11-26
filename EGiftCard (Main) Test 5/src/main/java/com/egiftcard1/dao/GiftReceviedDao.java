package com.egiftcard1.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.GiftReceivedDetails;

public interface GiftReceviedDao extends JpaRepository<GiftReceivedDetails, Integer> {

}
