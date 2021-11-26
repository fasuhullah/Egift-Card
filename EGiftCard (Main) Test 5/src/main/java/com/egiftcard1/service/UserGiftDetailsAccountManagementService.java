package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import com.egiftcard1.entity.UserGiftDetails;
import com.egiftcard1.exception.UserGiftDetailsException;

public interface UserGiftDetailsAccountManagementService {
	List<UserGiftDetails> getAllUserGiftDetails();

	Optional<UserGiftDetails> getUserGiftDetails(int UserGiftDetailsId);

	UserGiftDetails addUser_Gift_details(UserGiftDetails User_Gift_details);

	UserGiftDetails UpdateUser_Gift_details(UserGiftDetails User_Gift_details);

	UserGiftDetails UpdateUser_Gift_detailsById(int User_Gift_detailsId) throws UserGiftDetailsException;

	String deleteUser_Gift_details(UserGiftDetails User_Gift_details);

	String deleteUser_Gift_detailsById(int User_Gift_detailsId);
}
