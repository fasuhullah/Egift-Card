package com.egiftcard1.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GiftCard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int giftCardId;
	/*@OneToMany (mappedBy = "giftCard")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private List<UserGiftDetails> userGiftDetails;*/
	private String giftCardName;
	private String brandList;
	
	private String redemptiondetails;
	private float minAmount=100;
	private float maxamount =10000;
	private String aboutGiftCard;
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public GiftCard() {
		super();
	}
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public GiftCard(int giftCardId, String giftCardName, String brandList,
			String redemptiondetails, float minAmount, float maxamount, String aboutGiftCard) {
		this.giftCardId = giftCardId;
		this.giftCardName = giftCardName;
		this.brandList = brandList;
		this.redemptiondetails = redemptiondetails;
		this.minAmount = minAmount;
		this.maxamount = maxamount;
		this.aboutGiftCard = aboutGiftCard;
	}
	
	public int getGiftCardId() {
		return giftCardId;
	}
	
	public void setGiftCardId(int giftCardId) {
		this.giftCardId = giftCardId;
	}
	public String getGiftCardName() {
		return giftCardName;
	}
	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}
	public String getBrandList() {
		return brandList;
	}
	public void setBrandList(String brandList) {
		this.brandList = brandList;
	}
	public String getRedemptiondetails() {
		return redemptiondetails;
	}
	public void setRedemptiondetails(String redemptiondetails) {
		this.redemptiondetails = redemptiondetails;
	}
	public float getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(float minAmount) {
		this.minAmount = minAmount;
	}
	public float getMaxamount() {
		return maxamount;
	}
	public void setMaxamount(float maxamount) {
		this.maxamount = maxamount;
	}
	public String getAboutGiftCard() {
		return aboutGiftCard;
	}
	public void setAboutGiftCard(String aboutGiftCard) {
		this.aboutGiftCard = aboutGiftCard;
	}
	/*
	public List<UserGiftDetails> getUserGiftDetails() {
		return Collections.unmodifiableList(userGiftDetails);
	}
	public void setUserGiftDetails(List<UserGiftDetails> userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}*/
	@Override
	public String toString() {
		return "Gift_Card [giftCardId=" + giftCardId + ", giftCardName=" + giftCardName + ", brandList=" + brandList
				+ ", redemptiondetails=" + redemptiondetails + ", minAmount=" + minAmount + ", maxamount=" + maxamount
				+ ", aboutGiftCard=" + aboutGiftCard + "]";
	}
	
}
