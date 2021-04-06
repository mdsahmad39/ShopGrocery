package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String category;
	private int availableQuantity;
	private double price;
	private String fileName;
	private String createdDate;
	private String expiryDate;
	private String description;

	@ManyToOne
	@JoinColumn(name = "store_id")
	@JsonIgnore
	Store storeProduct;

	/*
	@OneToOne(mappedBy = "product", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	OrderDetails orderDetails;
	*/

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String category, int availableQuantity, double price,
			String createdDate, String expiryDate, Store store) {
		super();
		this.productName = productName;
		this.category = category;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
		this.storeProduct = store;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Store getStore() {
		return storeProduct;
	}

	public void setStore(Store store) {
		this.storeProduct = store;
	}

/*
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
*/
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", availableQuantity=" + availableQuantity + ", price=" + price + ", fileName="
				+ fileName + ", createdDate=" + createdDate + ", expiryDate=" + expiryDate + ", description="
				+ description + ", storeProduct=" + storeProduct + "]";
	}
	

}
