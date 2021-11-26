package com.egiftcard1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.UserGiftDetails;
import com.egiftcard1.exception.UserGiftDetailsException;
import com.egiftcard1.service.UserGiftDetailsAccountManagementService;
@RestController
@RequestMapping("/usergiftdetails")
public class UserGiftDetailsController {
	
	@Autowired
	UserGiftDetailsAccountManagementService userGiftDetailsService;
	
	@GetMapping("/usergiftdetails")
	public List<UserGiftDetails> getAllUserGiftDetails(){
		return userGiftDetailsService.getAllUserGiftDetails();
	}
	@GetMapping("/recieved/{id}")
	public Optional<UserGiftDetails> getUserGiftDetails(@PathVariable int UserGiftDetailsId){
		return userGiftDetailsService.getUserGiftDetails(UserGiftDetailsId);
	}
	@PostMapping("/usergiftdetail")
	public UserGiftDetails addUser_Gift_details(@RequestBody UserGiftDetails User_Gift_details) {
		return userGiftDetailsService.addUser_Gift_details(User_Gift_details);
	}
	@PutMapping("/update")
	public UserGiftDetails UpdateUser_Gift_details(@RequestBody UserGiftDetails User_Gift_details) {
		return userGiftDetailsService.UpdateUser_Gift_details(User_Gift_details);
	}
	@PutMapping("/update/{id}")
	public UserGiftDetails UpdateUser_Gift_detailsById(@PathVariable int User_Gift_detailsId) throws UserGiftDetailsException{
		return userGiftDetailsService.UpdateUser_Gift_detailsById(User_Gift_detailsId);
		
	}
	@DeleteMapping("/delete")
	String deleteUser_Gift_details(@RequestBody UserGiftDetails User_Gift_details) {
		return userGiftDetailsService.deleteUser_Gift_details(User_Gift_details);
	}
	@DeleteMapping("/delete/{id}")
	String deleteUser_Gift_detailsById(int User_Gift_detailsId) {
		return userGiftDetailsService.deleteUser_Gift_detailsById(User_Gift_detailsId);
	}
}
