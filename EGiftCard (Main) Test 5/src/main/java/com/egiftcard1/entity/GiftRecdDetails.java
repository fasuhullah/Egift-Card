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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Gift_Recd_details")
public class GiftRecdDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serialNumber;
	private Date giftCardReceivedDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private List<Customer> recdUserId = new ArrayList<>();
	@ManyToMany
	@JoinColumn(name = "User_GiftId")
	private List<UserGiftDetails> userGiftId = new ArrayList<>();

	public GiftRecdDetails() {
		super();
	}

	public GiftRecdDetails(Integer serialNumber, Date giftCardReceivedDate) {
		super();
		this.serialNumber = serialNumber;
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getGiftCardReceivedDate() {
		return giftCardReceivedDate;
	}

	public void setGiftCardReceivedDate(Date giftCardReceivedDate) {
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public List<Customer> getRecdUserId() {
		return recdUserId;
	}

	public void setRecdUserId(List<Customer> recdUserId) {
		this.recdUserId = recdUserId;
	}

	public void addUser(Customer usr) {
		this.getRecdUserId().add(usr);
	}
	@Override
	public String toString() {
		return "Gift_recd_details [SerialNumber=" + serialNumber + ", giftCardReceivedDate=" + giftCardReceivedDate
				+ " userId=" + recdUserId + ",]";
	}

}
