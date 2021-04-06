package com.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private String sellerName;
	private long phoneNumber;
	private String emailId;
	private String fileName;

	@Column(unique = true)
	private String loginId;
	private String password;

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	Address addressStore;

	@OneToMany(mappedBy = "storeProduct",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	Set<Product> products = new HashSet<Product>();

	/*@OneToMany(mappedBy = "storeOrders",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonManagedReference
	//@JsonIgnore
	Set<Orders> orders = new HashSet<Orders>();
	*/
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(String storeName, String sellerName, Address address, long phoneNumber, String emailId, String imageURL, String loginId,
			String password) {
		super();
		this.storeName = storeName;
		this.sellerName = sellerName;
		this.addressStore = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.loginId = loginId;
		this.password = password;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Address getAddress() {
		return addressStore;
	}

	public void setAddress(Address address) {
		this.addressStore = address;
	}

	public long getPhone() {
		return phoneNumber;
	}

	public void setPhone(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	/*
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	*/

	/*public byte[] getStoreImage() {
		return StoreImage;
	}

	public void setStoreImage(byte[] storeImage) {
		StoreImage = storeImage;
	}*/

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

/*	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", sellerName=" + sellerName
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", StoreImage="
				+ Arrays.toString(StoreImage) + ", fileName=" + fileName + ", loginId=" + loginId + ", password="
				+ password + ", addressStore=" + addressStore + ", products=" + products + ", orders=" + orders + "]";
	}
*/

}
