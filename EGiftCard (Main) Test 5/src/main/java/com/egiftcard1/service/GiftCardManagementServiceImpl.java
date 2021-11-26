package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard1.dao.GiftCardDao;
import com.egiftcard1.entity.GiftCard;
import com.egiftcard1.exception.GiftCardDeleteException;
import com.egiftcard1.exception.GiftCardException;
@Service
public class GiftCardManagementServiceImpl implements GiftCardManagementService {
	@Autowired
	GiftCardDao giftCardManage; 
	public List<GiftCard> getAllGift_Cards() {
		return giftCardManage.findAll();
	}
	@Override
	public Optional<GiftCard> getGiftCardById(int cusid) {
		return giftCardManage.findById(cusid);
	}

    @Override
	public GiftCard RegisterGift_Card(GiftCard Gift_Card) {
		return giftCardManage.save(Gift_Card);
	}

	@Override
	public GiftCard UpdateGift_Card(GiftCard Gift_Card) {
		
		return giftCardManage.save(Gift_Card);
	}

	@Override
	public GiftCard UpdateGift_CardById(Integer GiftCardId) throws GiftCardException {
		Optional<GiftCard> managementOptional = giftCardManage.findById(GiftCardId);
		if(managementOptional.isPresent()) {
			return giftCardManage.save(managementOptional.get());
		}
		else {
			throw new GiftCardException("Gift_Card Details Not Found");
		}
	     
		}

	@Override
	public String deleteGift_Card(GiftCard Gift_Card) {
		giftCardManage.delete(Gift_Card);		
		return "GiftCard deleted";
	}

	@Override
	public String deleteGift_CardById(Integer GiftCardId) throws GiftCardDeleteException {
		GiftCard deleteManagement = giftCardManage.getById(GiftCardId);
		if(deleteManagement !=null) {
			giftCardManage.delete(deleteManagement);
		}
		else {
			throw new GiftCardDeleteException("Gift_Card Details Not Found");
		}
		return "Card Deleted";
	}
}