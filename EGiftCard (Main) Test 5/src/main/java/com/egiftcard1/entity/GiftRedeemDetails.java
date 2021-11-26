package com.egiftcard1.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GiftRedeemDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer giftRedeemId; //Gift card redeem Id
	private boolean redeemStatus; //Gift card redeem status
	private Date giftRedeemDate; //date on which the card was redeemed
	@NotEmpty(message = "redeem amount needed")
	private float giftRedeemAmount; //Amount redeemed using the gift card
	@NotEmpty(message = "balance cannot be zero")
	private float balance; //Balance of Gift card
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_gift_details")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private List<UserGiftDetails> userGiftDetails = new ArrayList<>();

	public GiftRedeemDetails() {
		super();
	}

	public GiftRedeemDetails(Integer giftRedeemId, boolean redeemStatus, Date giftRedeemDate, float giftRedeemAmount,
			float balance) {
		this.giftRedeemId = giftRedeemId;
		this.redeemStatus = redeemStatus;
		this.giftRedeemDate = giftRedeemDate;
		this.giftRedeemAmount = giftRedeemAmount;
		this.balance = balance;
	}

	public Integer getGiftRedeemId() {
		return giftRedeemId;
	}

	public void setGiftRedeemId(Integer giftRedeemId) {
		this.giftRedeemId = giftRedeemId;
	}

	public boolean isRedeemStatus() {
		return redeemStatus;
	}

	public void setRedeemStatus(boolean redeemStatus) {
		this.redeemStatus = redeemStatus;
	}

	public Date getGiftRedeemDate() {
		return giftRedeemDate;
	}

	public void setGiftRedeemDate(Date giftRedeemDate) {
		this.giftRedeemDate = giftRedeemDate;
	}

	public float getGiftRedeemAmount() {
		return giftRedeemAmount;
	}

	public void setGiftRedeemAmount(float giftRedeemAmount) {
		this.giftRedeemAmount = giftRedeemAmount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Gift_redeem_details [gift_redeem_id=" + giftRedeemId + ", redeemStatus=" + redeemStatus
				+ ", giftRedeemDate=" + giftRedeemDate + ", giftRedeemAmount=" + giftRedeemAmount + ", balance="
				+ balance + ",]";
	}

}
