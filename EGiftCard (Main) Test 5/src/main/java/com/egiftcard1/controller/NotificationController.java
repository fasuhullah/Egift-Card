package com.egiftcard1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.GiftRecdDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.exception.InsufficientBalanceException;
import com.egiftcard1.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	private NotificationService notification;

	@GetMapping("/recieved")
	public List<GiftRecdDetails> getAllGiftRecdDetails() {
		return notification.getAllGiftRecdDetails();

	}
	
	@GetMapping("/redeemed")
	public List<GiftRedeemDetails> getAllGiftRedeemDetails(){
		return notification.getAllGiftRedeemDetails();
	}

	@PostMapping("/mail/recievied/{id}")
	public GiftRecdDetails sendGiftRecdDetails(@RequestBody GiftRecdDetails giftRecdDetails, @PathVariable Integer id) {

		 return notification.sendGiftRecdDetailsNotification(giftRecdDetails, id);

	}
	
	@PostMapping("/mail/redeem/{amount}")
	public GiftRedeemDetails sendGiftRedeemDetails(@RequestBody GiftRedeemDetails giftRedeemDetails, @PathVariable float amount) throws InsufficientBalanceException {

		return notification.sendGiftRedeemDetailsNotification(giftRedeemDetails, amount);

	}
	
	
}
