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
	private Integer gift_redeem_id;
	private boolean redeemStatus;
	private Date giftRedeemDate;
	@NotEmpty(message="redeem amount needed")
	private float giftRedeemAmount;
	@NotEmpty(message="balance cannot be zero")
	private float balance;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_gift_details")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private List<UserGiftDetails> userGiftDetails = new ArrayList<>();

	public GiftRedeemDetails() {
		super();
	}
	public GiftRedeemDetails(Integer gift_redeem_id, boolean redeemStatus, Date giftRedeemDate, float giftRedeemAmount,
			float balance) {
		this.gift_redeem_id = gift_redeem_id;
		this.redeemStatus = redeemStatus;
		this.giftRedeemDate = giftRedeemDate;
		this.giftRedeemAmount = giftRedeemAmount;
		this.balance = balance;
	}

	public Integer getGift_redeem_id() {
		return gift_redeem_id;
	}

	public void setGift_redeem_id(Integer gift_redeem_id) {
		this.gift_redeem_id = gift_redeem_id;
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
		return "Gift_redeem_details [gift_redeem_id=" + gift_redeem_id + ", redeemStatus=" + redeemStatus
				+ ", giftRedeemDate=" + giftRedeemDate + ", giftRedeemAmount=" + giftRedeemAmount + ", balance="
				+ balance + ",]";
	}

}
