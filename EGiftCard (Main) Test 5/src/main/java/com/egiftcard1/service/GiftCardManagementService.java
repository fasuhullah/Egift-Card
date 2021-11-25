package com.egiftcard1.service;
import java.util.List;

import com.egiftcard1.entity.GiftCard;

public interface GiftCardManagementService {
	List<GiftCard> getAllGift_Cards();
	GiftCard getGift_CardById(int GiftCardId);
	GiftCard RegisterGift_Card(GiftCard Gift_Card);
	GiftCard UpdateGift_Card(GiftCard Gift_Card);
	GiftCard UpdateGift_CardById(int GiftCardId);
	String deleteGift_Card(GiftCard Gift_Card);
	String deleteGift_CardById(int GiftCardId);
}
