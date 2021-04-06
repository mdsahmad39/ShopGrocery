package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ordersId;
	private String orderStatus;
	private String ordersDate;

	private int storeId;
	/*
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	//@JsonIgnore
	@JsonBackReference
	@JoinColumn(name = "store_id")
	Store storeOrders;
	*/

	private int userId;
	/*
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
	//@JsonIgnore
	@JsonBackReference
	@JoinColumn(name = "user_id")
	Customer customer;
	*/
	
	@OneToMany(mappedBy = "order", fetch=FetchType.LAZY)
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIgnore
	List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderStatus, String orderDate, int storeId, int customerId) {
		super();
		this.orderStatus = orderStatus;
		this.ordersDate = orderDate;
		this.storeId = storeId;
		this.userId = customerId;
	}

	public int getOrderId() {
		return ordersId;
	}

	public void setOrderId(int orderId) {
		this.ordersId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return ordersDate;
	}

	public void setOrderDate(String orderDate) {
		this.ordersDate = orderDate;
	}

	public int getStore() {
		return storeId;
	}

	public void setStore(int storeId) {
		this.storeId = storeId;
	}

	public int getCustomer() {
		return userId;
	}

	public void setCustomer(int customerId) {
		this.userId = customerId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + ordersId + ", orderStatus=" + orderStatus + ", orderDate=" + ordersDate + ", storeId="
				+ storeId + ", customerId=" + userId + "]";
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetailsList;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetailsList = orderDetails;
	}

}
