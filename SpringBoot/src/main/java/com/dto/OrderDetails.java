package com.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDetailsId;
	private int purchasedQuantity;
	private double totalPrice;

	private int productId;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	Orders order;
	/*
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	Product product;
	*/
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int purchasedQuantity, double totalPrice, Orders order,
			int productId) {
		super();
		this.purchasedQuantity = purchasedQuantity;
		this.totalPrice = totalPrice;
		this.order = order;
		this.productId = productId;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public void setPurchasedQuantity(int purchasedQuantity) {
		this.purchasedQuantity = purchasedQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getProduct() {
		return productId;
	}

	public void setProduct(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", purchasedQuantity=" + purchasedQuantity + ", totalPrice=" + totalPrice + ", order=" + order
				+ ", productId=" + productId + "]";
	}

	public void setProductId(int productId2) {
		this.productId=productId2;
		
	}

}
