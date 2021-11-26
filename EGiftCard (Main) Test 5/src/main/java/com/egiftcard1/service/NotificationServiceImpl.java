package com.egiftcard1.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.CustomerRepository;
import com.egiftcard1.dao.GiftReceviedDao;
import com.egiftcard1.dao.GiftRedeemDao;
import com.egiftcard1.entity.Customer;
import com.egiftcard1.entity.GiftReceivedDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.entity.UserGiftDetails;
import com.egiftcard1.exception.InsufficientBalanceException;
import com.egiftcard1.exception.InvalidCustomerIdException;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	GiftReceviedDao giftRecd;
	
	@Autowired
	GiftRedeemDao giftRedeem;
	
	@Autowired
	EmailSenderService emailSender;
	
	@Autowired
	private CustomerRepository cusRepo;
	
	Customer cus;
	
	GiftReceivedDetails grd;
	
	UserGiftDetails ugd = new UserGiftDetails();
	
	GiftRedeemDetails gRedeemDet = new GiftRedeemDetails();

	@Override
	public List<GiftReceivedDetails> getAllGiftReceivedDetails() { // Get all gift received details
		return giftRecd.findAll();
	}

	@Override
	public List<GiftRedeemDetails> getAllGiftRedeemDetails() { // Get all gift redeemed details
		return giftRedeem.findAll();
	}

	@Override
	public GiftRedeemDetails sendGiftRedeemDetailsNotification(GiftRedeemDetails giftRedeemDetails, float amount)
			throws InsufficientBalanceException { // Send gift card redeemed notification through mail
		if (giftRedeemDetails.getBalance() > giftRedeemDetails.getGiftRedeemAmount()) {
			float balance = giftRedeemDetails.getBalance() - giftRedeemDetails.getGiftRedeemAmount();
			giftRedeemDetails.setBalance(balance);
			giftRedeemDetails.setGiftRedeemAmount(giftRedeemDetails.getGiftRedeemAmount());
			giftRedeemDetails.setRedeemStatus(true);
			giftRedeem.save(giftRedeemDetails);
			emailSender.sendSimpleMail(ugd.getRecipientsEmail(), giftRedeemDetails.toString(), "Gift card redeemed");
		} else {
			throw new InsufficientBalanceException("Insifficient balance to redeem");
		}

		return giftRedeemDetails;

	}

	@Override
	public GiftReceivedDetails sendGiftReceivedDetailsNotification(GiftReceivedDetails giftRecdDetails, int id, String toEmail) { // Send gift card received notification
																												
		cus = cusRepo.getById(id);
		gRedeemDet.setBalance(ugd.getGiftCardAmount());
		if (cus != null) {
			giftRecdDetails.addUser(cus);
			giftRecd.save(giftRecdDetails);
			emailSender.sendSimpleMail(toEmail, giftRecdDetails.toString(), "Gift card recieved");
		} else {
			throw new InvalidCustomerIdException("Invalid customer id, Customer not found");
		}

		return giftRecdDetails;

	}

}
