package com.egiftcard1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.egiftcard1.entity.GiftRecdDetails;

@Component
@Entity
public class Customer implements Serializable{

	private static final long serialVersionID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  customerId ;
	
	@NotEmpty(message = "Firstname is required")
	@Size(min = 3, message = "Firstname should be atleast 3 letters")
	private String firstName;
	
	@NotEmpty(message = "Lastname is required")
	@Size(min = 4, message = "Laststname should be atleast 4 letters")
	private String lastName ;
	
	@NotEmpty(message = "Email is required")
	@Email
	private String email;
	
	@NotEmpty(message = "Mobile number is required")
	private String mobile;
	
	@NotEmpty(message = "Password is required")
	@Size(min = 4, message = "password should contain atleast 4 characters")
	private String password;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "recdUserId")
	private List<GiftRecdDetails> userRecdDetails;
	
	public Customer() {
		super();

	}

	public Customer(int customerId, String firstName, String lastName, String email, String mobile, String password,
			String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + ", address=" + address + "]";
	}

}
