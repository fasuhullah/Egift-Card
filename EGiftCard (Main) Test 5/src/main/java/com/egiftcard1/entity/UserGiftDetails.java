package com.egiftcard1.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class UserGiftDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userGiftId;
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Customer user;
	
	/*@ManyToOne
	@JoinColumn(name = "giftCard_Id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private GiftCard giftCard;*/
	
	/*@ManyToMany(mappedBy = "userGiftId")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private List<GiftReceivedDetails> giftRecdDetails = new ArrayList<>();*/
	
	/*@ManyToMany(mappedBy = "userGiftDetails")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private List<GiftRedeemDetails> giftRedDDetails;*/
	
	private float giftCardAmount;
	private Date giftCardIssueDate;
	private boolean reloadable;
	private String recipientsName;
	private String recipientsMobileNumber;
	private String recipientsEmail;
	private String delivaryType;
	private LocalDate scheduledelivary;
	@OneToMany(mappedBy = "userGiftDetails")
	private List<PaymentDetails> paymentDetails;
	
	

	


	public UserGiftDetails() {
		super();
	}


	public UserGiftDetails(Integer userGiftId, float giftCardAmount, Date giftCardIssueDate, boolean reloadable,
			String recipientsName, String recipientsMobileNumber, String recipientsEmail, String delivaryType,
			LocalDate scheduledelivary) {
		super();
		this.userGiftId = userGiftId;
		this.giftCardAmount = giftCardAmount;
		this.giftCardIssueDate = giftCardIssueDate;
		this.reloadable = reloadable;
		this.recipientsName = recipientsName;
		this.recipientsMobileNumber = recipientsMobileNumber;
		this.recipientsEmail = recipientsEmail;
		this.delivaryType = delivaryType;
		this.scheduledelivary = scheduledelivary;
	}


	public int getUserGiftId() {
		return userGiftId;
	}

	
	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	public Customer getUserId() {
		return user;
	}

	public void setUserId(Customer userId) {
		this.user = userId;
	}

	/*public GiftCard getGiftCardId() {
		return giftCard;
	}

	public void setGiftCardId(GiftCard giftCardId) {
		this.giftCard = giftCardId;
	}*/

	public float getGiftCardAmount() {
		return giftCardAmount;
	}

	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	public Date getGiftCardIssueDate() {
		return giftCardIssueDate;
	}

	public void setGiftCardIssueDate(Date giftCardIssueDate) {
		this.giftCardIssueDate = giftCardIssueDate;
	}

	public boolean isReloadable() {
		return reloadable;
	}

	public void setReloadable(boolean reloadable) {
		this.reloadable = reloadable;
	}

	public String getRecipientsName() {
		return this.recipientsName;
	}

	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}

	public String getRecipientsMobileNumber() {
		return recipientsMobileNumber;
	}

	public void setRecipientsMobileNumber(String recipientsMobileNumber) {
		this.recipientsMobileNumber = recipientsMobileNumber;
	}

	public String getRecipientsEmail() {
		return recipientsEmail;
	}

	public void setRecipientsEmail(String recipientsEmail) {
		this.recipientsEmail = recipientsEmail;
	}

	public String getDelivaryType() {
		return delivaryType;
	}

	public void setDelivaryType(String delivaryType) {
		this.delivaryType = delivaryType;
	}

	public LocalDate getScheduledelivary() {
		return scheduledelivary;
	}

	public void setScheduledelivary(LocalDate scheduledelivary) {
		this.scheduledelivary = scheduledelivary;
	}


	public Customer getUser_Id() {
		return user;
	}

	public void setUser_Id(Customer user_Id) {
		this.user = user_Id;
	}

	/*public GiftCard getGiftCard_Id() {
		return giftCard;
	}

	public void setGiftCard_Id(GiftCard giftCard_Id) {
		this.giftCard = giftCard_Id;
	}*/

	/*public List<GiftReceivedDetails> getGiftRecdDetails() {
		return giftRecdDetails;
	}

	public void setGiftRecdDetails(List<GiftReceivedDetails> giftRecdDetails) {
		this.giftRecdDetails = giftRecdDetails;
	}

	public List<GiftRedeemDetails> getGiftRedDDetails() {
		return Collections.unmodifiableList(giftRedDDetails);
	}

	public void setGiftRedDDetails(List<GiftRedeemDetails> giftRedDDetails) {
		this.giftRedDDetails = giftRedDDetails;
	}*/

	public void setUserGiftId(Integer userGiftId) {
		this.userGiftId = userGiftId;
	}


	@Override
	public String toString() {
		return "UserGiftDetails [userGiftId=" + userGiftId + ", giftCardAmount=" + giftCardAmount
				+ ", giftCardIssueDate=" + giftCardIssueDate + ", reloadable=" + reloadable + ", recipientsName="
				+ recipientsName + ", recipientsMobileNumber=" + recipientsMobileNumber + ", recipientsEmail="
				+ recipientsEmail + ", delivaryType=" + delivaryType + ", scheduledelivary=" + scheduledelivary + "]";
	}


	
	}

	
