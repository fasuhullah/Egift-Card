package com.egiftcard1.service;

import java.util.List;
import java.util.Optional;

import com.egiftcard1.entity.GiftCard;
import com.egiftcard1.exception.GiftCardDeleteException;
import com.egiftcard1.exception.GiftCardException;

public interface GiftCardManagementService {
	List<GiftCard> getAllGift_Cards();

	Optional<GiftCard> getGiftCardById(int cusid);

	GiftCard RegisterGift_Card(GiftCard Gift_Card);

	GiftCard UpdateGift_Card(GiftCard Gift_Card);

	GiftCard UpdateGift_CardById(Integer GiftCardId) throws GiftCardException;

	String deleteGift_Card(GiftCard Gift_Card);

	String deleteGift_CardById(Integer GiftCardId) throws GiftCardDeleteException;
}
