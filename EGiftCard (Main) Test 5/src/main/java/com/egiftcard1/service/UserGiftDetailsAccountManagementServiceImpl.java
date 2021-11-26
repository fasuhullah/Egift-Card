package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.UserGiftDetailsAccountManagementDao;
import com.egiftcard1.entity.UserGiftDetails;
import com.egiftcard1.exception.UserGiftDetailsException;

import io.swagger.v3.oas.annotations.servers.Server;
@Service
public class UserGiftDetailsAccountManagementServiceImpl implements UserGiftDetailsAccountManagementService {
	@Autowired
	private UserGiftDetailsAccountManagementDao userGiftDet;

	@Override
	public List<UserGiftDetails> getAllUserGiftDetails() {
		return userGiftDet.findAll();

	}

	@Override
	public Optional<UserGiftDetails> getUserGiftDetails(int UserGiftDetailsId) {
		return userGiftDet.findById(UserGiftDetailsId);
	}

	@Override
	public UserGiftDetails addUser_Gift_details(UserGiftDetails User_Gift_details) {
		return userGiftDet.save(User_Gift_details);
	}

	@Override
	public UserGiftDetails UpdateUser_Gift_details(UserGiftDetails User_Gift_details) {

		return userGiftDet.save(User_Gift_details);
	}

	@Override
	public UserGiftDetails UpdateUser_Gift_detailsById(int User_Gift_detailsId) throws UserGiftDetailsException {
		Optional<UserGiftDetails> userGiftDetailsOptional = userGiftDet.findById(User_Gift_detailsId);

		if (userGiftDetailsOptional.isPresent()) {
			return userGiftDet.save(userGiftDetailsOptional.get());
		} else {
			throw new UserGiftDetailsException("User Not Found");
		}
	}

	@Override
	public String deleteUser_Gift_details(UserGiftDetails User_Gift_details) {
		userGiftDet.delete(User_Gift_details);
		return "User gift details successfully deleted";
	}

	@Override
	public String deleteUser_Gift_detailsById(int User_Gift_detailsId) {
		userGiftDet.deleteById(User_Gift_detailsId);
		return "User gift details successfully deleted";
	}

}
