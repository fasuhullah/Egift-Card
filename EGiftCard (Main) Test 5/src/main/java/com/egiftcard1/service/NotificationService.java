package com.egiftcard1.service;

import java.util.List;

import com.egiftcard1.entity.GiftReceivedDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.exception.InsufficientBalanceException;

public interface NotificationService {
	
	List<GiftReceivedDetails> getAllGiftReceivedDetails(); // Get all gift received details
	List<GiftRedeemDetails> getAllGiftRedeemDetails();// Get all gift redeemed details
	
	GiftRedeemDetails sendGiftRedeemDetailsNotification(GiftRedeemDetails giftRedeemDetails, float amount) throws InsufficientBalanceException; // Send gift card received notification through mail
	
	GiftReceivedDetails sendGiftReceivedDetailsNotification(GiftReceivedDetails giftRecdDetails, int id, String toEmail); //Send gift card redeemed notification through mail

}
