package com.egiftcard1.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.GiftRecdDetails;

public interface GiftRecdDao extends JpaRepository<GiftRecdDetails, Integer> {

}
