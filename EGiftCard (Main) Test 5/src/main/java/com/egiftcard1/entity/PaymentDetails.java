package com.egiftcard1.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PaymentDetails")
public class PaymentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer paymentId;

	@NotEmpty
	private String paymentDate;

	@NotNull
	private Float paymentAmount;

	@NotEmpty
	@Size(min = 3, max = 20, message = "Length must be min 3 chars and max 20 chars.")
	private String nameOnTheCard;

	@NotEmpty
	@Pattern(regexp = "^4[0-9]{15}$", message = "cardNumber starting with 4 and having 16 digits")
	private String cardNumber;

	@NotEmpty
	@Pattern(regexp = "^(0[1-9]|1[0-2])/([0-9]{2})$", message = "format should be MM/YY")
	private String cardexpiry;

	@NotEmpty
	@Pattern(regexp = "^[0-9]{3}$", message = "CVV should be of 3 digits ")
	private String cVV;

	//@ManyToOne 
	//(name ="userGift_Id")
	/*private UserGiftDetails userGiftIdForPayment;
		// @NotFound(action=NotFoundAction.IGNORE)
		// private User_Gift_details userGiftId;
		// create getter n setter
*/
	
	
	public PaymentDetails() {
		super();
	}

	public PaymentDetails(Integer paymentId, String paymentDate, Float paymentAmount, String nameOnTheCard,
			String cardNumber, String cardexpiry, String cVV) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.nameOnTheCard = nameOnTheCard;
		this.cardNumber = cardNumber;
		this.cardexpiry = cardexpiry;
		this.cVV = cVV;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentAmount="
				+ paymentAmount + ", nameOnTheCard=" + nameOnTheCard + ", cardNumber=" + cardNumber + ", cardexpiry="
				+ cardexpiry + ", cVV=" + cVV + "]";
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardexpiry() {
		return cardexpiry;
	}

	public void setCardexpiry(String cardexpiry) {
		this.cardexpiry = cardexpiry;
	}

	public String getcVV() {
		return cVV;
	}

	public void setcVV(String cVV) {
		this.cVV = cVV;
	}

	
}
