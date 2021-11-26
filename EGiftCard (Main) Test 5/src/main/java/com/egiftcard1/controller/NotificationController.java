package com.egiftcard1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.GiftReceivedDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.exception.InsufficientBalanceException;
import com.egiftcard1.service.NotificationService;

@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	private NotificationService notification;

	@GetMapping("/recieved")
	public List<GiftReceivedDetails> getAllGiftRecdDetails() { // Get all gift received details
		return notification.getAllGiftReceivedDetails();

	}

	@GetMapping("/redeemed")
	public List<GiftRedeemDetails> getAllGiftRedeemDetails() { // Get all gift redeemed details
		return notification.getAllGiftRedeemDetails();
	}

	@PostMapping("/mail/recievied/{id} {toEmail}") // Send gift card received notification through mail
	public GiftReceivedDetails sendGiftRecdDetails(@RequestBody GiftReceivedDetails giftRecdDetails, @PathVariable Integer id, @PathVariable String toEmail) {

		return notification.sendGiftReceivedDetailsNotification(giftRecdDetails, id, toEmail);

	}

	@PostMapping("/mail/redeem/{amount}") //Send gift card redeemed notification through mail
	public GiftRedeemDetails sendGiftRedeemDetails(@RequestBody GiftRedeemDetails giftRedeemDetails,
			@PathVariable float amount) throws InsufficientBalanceException {

		return notification.sendGiftRedeemDetailsNotification(giftRedeemDetails, amount);

	}

}
