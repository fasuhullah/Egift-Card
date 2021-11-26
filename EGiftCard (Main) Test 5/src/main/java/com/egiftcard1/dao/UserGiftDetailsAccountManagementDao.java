package com.egiftcard1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egiftcard1.entity.UserGiftDetails;

public interface UserGiftDetailsAccountManagementDao extends JpaRepository<UserGiftDetails, Integer> {

}
