package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private long phoneNumber;

	@Column(unique = true)
	private String loginId;
	private String password;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	Address addressCustomer;

	/*
	@OneToMany(mappedBy = "customer")
	List<Orders> orders = new ArrayList<Orders>();
	*/
	
	public Customer() {
	}

	public Customer(String firstName, String lastName, String gender, Address address, String emailId,
			long phoneNumber, String loginId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.addressCustomer = address;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.loginId = loginId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return addressCustomer;
	}

	public void setAddress(Address address) {
		this.addressCustomer = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", loginId=" + loginId
				+ ", password=" + password + ", address=" + addressCustomer + "]";
	}

	

}
