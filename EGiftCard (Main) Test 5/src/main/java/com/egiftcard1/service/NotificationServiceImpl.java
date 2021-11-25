package com.egiftcard1.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.CustomerRepository;
import com.egiftcard1.dao.GiftRecdDao;
import com.egiftcard1.dao.GiftRedeemDao;
import com.egiftcard1.entity.Customer;
import com.egiftcard1.entity.GiftRecdDetails;
import com.egiftcard1.entity.GiftRedeemDetails;
import com.egiftcard1.entity.UserGiftDetails;
import com.egiftcard1.exception.InsufficientBalanceException;
import com.egiftcard1.exception.InvalidCustomerIdException;



@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	GiftRecdDao giftRecd;
	@Autowired
	GiftRedeemDao giftRedeem;
	@Autowired
	EmailSenderService emailSender;
	@Autowired
	private CustomerRepository cusRepo;
	Customer cus;
	GiftRecdDetails grd;
	UserGiftDetails ugd = new UserGiftDetails();
	GiftRedeemDetails gRedeemDet = new GiftRedeemDetails();

	@Override
	public List<GiftRecdDetails> getAllGiftRecdDetails() {
		return giftRecd.findAll();
	}

	@Override
	public List<GiftRedeemDetails> getAllGiftRedeemDetails() {
		return giftRedeem.findAll();
	}

	@Override
	public GiftRedeemDetails sendGiftRedeemDetailsNotification(GiftRedeemDetails giftRedeemDetails, float amount) throws InsufficientBalanceException {
		if (giftRedeemDetails.getBalance() > giftRedeemDetails.getGiftRedeemAmount()) {
			float balance = giftRedeemDetails.getBalance() - giftRedeemDetails.getGiftRedeemAmount();
			giftRedeemDetails.setBalance(balance);
			giftRedeemDetails.setGiftRedeemAmount(amount);
			giftRedeemDetails.setRedeemStatus(true);
			giftRedeem.save(giftRedeemDetails);
			emailSender.sendSimpleMail(ugd.getRecipientsEmail(), giftRedeemDetails.toString(), "Gift card redeemed");
		}
		else {
			throw new InsufficientBalanceException("Insifficient balance to redeem");
		}

		return giftRedeemDetails;

	}

	@Override
	public GiftRecdDetails sendGiftRecdDetailsNotification(GiftRecdDetails giftRecdDetails, int id) {
		cus = cusRepo.getById(id);
		gRedeemDet.setBalance(ugd.getGiftCardAmount());
		if (cus != null) {
			giftRecdDetails.addUser(cus);
			giftRecd.save(giftRecdDetails);
			emailSender.sendSimpleMail(ugd.getRecipientsEmail(), giftRecdDetails.toString(), "Gift card recieved");
		}
		else {
			 throw new InvalidCustomerIdException("Invalid customer id, Customer not found");
		}

		return giftRecdDetails;

	}

}
