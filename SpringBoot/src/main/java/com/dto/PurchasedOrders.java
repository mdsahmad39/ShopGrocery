package com.dto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedOrders {
	private int ordersId;
	private String ordersStatus;
	private String ordersDate;

	private int storeId;
	private int userId;
	public String[] orderDetailsList;
	
	
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getOrdersStatus() {
		return ordersStatus;
	}
	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	public String getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String[] getOrderDetails() {
		return orderDetailsList;
	}
	public void setOrderDetails(String[] orderDetails) {
		this.orderDetailsList = orderDetails;
	}
}
