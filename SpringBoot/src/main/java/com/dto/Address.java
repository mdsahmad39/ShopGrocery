package com.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String houseNo;
	private String street;
	private String city;
	private long pincode;
	private String state;
	private String country;
	
	@OneToOne(mappedBy="addressStore",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Store store;
	
	@OneToOne(mappedBy="addressCustomer",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Customer customer;
	
	public Address() {
		super();

	}

	public Address(String houseNo, String street, String city, long pincode, String state, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "houseNo=" + houseNo + " street=" + street + " city=" + city + " pincode=" + pincode + " state=" + state
				+ " country=" + country + "";

	}

}
