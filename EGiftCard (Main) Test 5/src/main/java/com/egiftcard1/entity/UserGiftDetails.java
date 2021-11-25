package com.egiftcard1.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private Customer user;
	
	@ManyToOne
	@JoinColumn(name = "giftCard_Id")
	private GiftCard giftCard;
	
	@ManyToMany(mappedBy = "userGiftId")
	private List<GiftRecdDetails> giftRecdDetails = new ArrayList<>();
	
	@ManyToMany(mappedBy = "userGiftDetails")
	private List<GiftRedeemDetails> giftRedDDetails;
	
	private float giftCardAmount = 1000f;
	private Date giftCardIssueDate;
	private boolean reloadable = true;
	private String recipientsName = "najeeb";
	private String recipientsMobileNumber ="939256545";
	private String recipientsEmail = "cricpunterfasi@gmail.com";
	private String delivaryType ="yes";
	private LocalDate scheduledelivary;
	/*@OneToMany(mappedBy = "userGiftIdForPayment")
	private List<PaymentDetails> paymentDetails;*/
	// @ManyToOne
	// private Personalize personalizeId;
	
	

	public UserGiftDetails(Integer userGiftId, Customer user, float giftCardAmount, Date giftCardIssueDate, boolean reloadable,
			String recipientsName, String recipientsMobileNumber, String recipientsEmail, String delivaryType,
			LocalDate scheduledelivary) {
		super();
		this.userGiftId = userGiftId;
		this.user = user;
		//this.giftCard = giftCard;
		//this.giftRecdDetails = giftRecdDetails;
		//this.giftRedDDetails = giftRedDDetails;
		this.giftCardAmount = giftCardAmount;
		this.giftCardIssueDate = giftCardIssueDate;
		this.reloadable = reloadable;
		this.recipientsName = recipientsName;
		this.recipientsMobileNumber = recipientsMobileNumber;
		this.recipientsEmail = recipientsEmail;
		this.delivaryType = delivaryType;
		this.scheduledelivary = scheduledelivary;
		//this.paymentDetails = paymentDetails;
	}


	public UserGiftDetails() {
		super();
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

	public GiftCard getGiftCardId() {
		return giftCard;
	}

	public void setGiftCardId(GiftCard giftCardId) {
		this.giftCard = giftCardId;
	}

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

	/*
	 * public Personalize getPersonalizeId() { return personalizeId; }
	 * 
	 * public void setPersonalizeId(Personalize personalizeId) { this.personalizeId
	 * = personalizeId; }
	 */

	public Customer getUser_Id() {
		return user;
	}

	public void setUser_Id(Customer user_Id) {
		this.user = user_Id;
	}

	public GiftCard getGiftCard_Id() {
		return giftCard;
	}

	public void setGiftCard_Id(GiftCard giftCard_Id) {
		this.giftCard = giftCard_Id;
	}

/*	public List<GiftRecdDetails> getGiftRecdDetails() {
		return giftRecdDetails;
	}

	public void setGiftRecdDetails(List<GiftRecdDetails> giftRecdDetails) {
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
		return "UserGiftDetails [userGiftId=" + userGiftId + ", giftCard=" + giftCard + ", giftCardAmount="
				+ giftCardAmount + ", giftCardIssueDate=" + giftCardIssueDate + ", reloadable=" + reloadable
				+ ", recipientsName=" + recipientsName + ", recipientsMobileNumber=" + recipientsMobileNumber
				+ ", recipientsEmail=" + recipientsEmail + ", delivaryType=" + delivaryType + ", scheduledelivary="
				+ scheduledelivary + "]";
	}

	
}