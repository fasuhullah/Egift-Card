package com.egiftcard1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard1.entity.GiftCard;
import com.egiftcard1.exception.GiftCardDeleteException;
import com.egiftcard1.exception.GiftCardException;
import com.egiftcard1.service.GiftCardManagementService;

@RestController
@RequestMapping("/gift")
public class GiftcardController {

	@Autowired
	private GiftCardManagementService giftCardService;

	@GetMapping("/Giftcards")
	public List<GiftCard> getAllGift_Cards() {
		return giftCardService.getAllGift_Cards();

	}

	@GetMapping("Giftcard/{id}")
	public Optional<GiftCard> getGift_CardById(@PathVariable Integer GiftCardId) throws GiftCardException {

		return giftCardService.getGiftCardById(GiftCardId);

	}

	@PutMapping("/update")
	public GiftCard UpdateGift_Card(@RequestBody GiftCard upGift_Card) throws GiftCardException {
		return giftCardService.UpdateGift_Card(upGift_Card);

	}

	@PutMapping("/update/{id}")
	public GiftCard updateGift_CardById(@PathVariable int cusId) throws GiftCardException {
		GiftCard giftcard = null;
		if (cusId != 0 && cusId > 0) {
			Optional<GiftCard> cus1 = giftCardService.getGiftCardById(cusId);
			if (!cus1.isPresent()) {
				throw new GiftCardException("Provided Gift_Card " + cusId + " not a Valid Gift_Card");
			} 
			else {
				 return giftCardService.UpdateGift_CardById(cusId);
				
			}
		}
		else {
			return new GiftCard();
		}
	}

	@PostMapping("/GiftCard")
	public GiftCard RegisterGift_Card(@RequestBody GiftCard newcus) throws GiftCardException {
		String tempEmailId = newcus.getRedemptiondetails();
		GiftCard giftcard = null;
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			GiftCard giftcard1 = giftCardService.RegisterGift_Card(giftcard);
			if (giftcard1 != null) {
				throw new GiftCardException("User with" + tempEmailId + "is already exists");
			}
		}
		giftcard = giftCardService.RegisterGift_Card(giftcard);
		return giftcard;
	}

	@RequestMapping(value = "/delete")
	public String deleteGift_Card(@RequestBody GiftCard delgiftcard) throws GiftCardException {
		return giftCardService.deleteGift_Card(delgiftcard);
	}

	@RequestMapping(value="/GiftCard/delete/{Id}",method=RequestMethod.DELETE)
   	public String deleteGift_CardById(@PathVariable Integer cusId) throws GiftCardDeleteException {
   		Optional<GiftCard> giftcard=giftCardService.getGiftCardById(cusId);
   		if(!giftcard.isPresent()) {
   			return "Could not find Gift_Card with id";
   		}
   			else
   				return giftCardService.deleteGift_CardById(cusId);
   		
   	}
}
