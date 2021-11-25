package com.egiftcard1.service;

import java.util.List;

import com.egiftcard1.entity.GiftRecdDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.exception.InsufficientBalanceException;

public interface NotificationService {
	
	List<GiftRecdDetails> getAllGiftRecdDetails();
	List<GiftRedeemDetails> getAllGiftRedeemDetails();
	
	GiftRedeemDetails sendGiftRedeemDetailsNotification(GiftRedeemDetails giftRedeemDetails, float amount) throws InsufficientBalanceException;
	
	GiftRecdDetails sendGiftRecdDetailsNotification(GiftRecdDetails giftRecdDetails, int id);

}
