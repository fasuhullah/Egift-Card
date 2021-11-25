package com.egiftcard1.entity;

import javax.persistence.OneToMany;

public class Personalize {
	//@OneToMany
	private int personalizeId ;
	enum personalizeType{ 
		birthday,Teacher,Wedding,Congratulations,Thankyou, WellDone,
			 Love,Anniversary, MissYou };
	private String image;
	public Personalize(int personalizeId, String image) {
		super();
		this.personalizeId = personalizeId;
		this.image = image;
	}
	public Personalize() {
	}
	public int getPersonalizeId() {
		return personalizeId;
	}
	public void setPersonalizeId(int personalizeId) {
		this.personalizeId = personalizeId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Personalize [personalizeId=" + personalizeId + ", image=" + image + "]";
	}


}
