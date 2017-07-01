package com.iotek.entity;

import java.sql.Timestamp;
import java.util.Date;


public class order {
	private String orderId;				//订单号
	private int userId;					//用户id
	private String userAddress;			//用户地址
	private double price;				//商品价格
	private String memo;				//备注
	private Timestamp time;				//订单时间
	
	public order(String orderId,int userId, String userAddress, double price) {
		super();
		this.orderId=orderId;
		this.userId = userId;
		this.userAddress = userAddress;
		this.price = price;
		
	
	}
	public order(String orderId, int userId, String userAddress, double price, String memo, Timestamp time) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userAddress = userAddress;
		this.price = price;
		this.memo = memo;
		this.time = time;
	}
	
	public order(String orderId){
		super();
		this.orderId = orderId;
	}

	public order() {
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "order [orderId=" + orderId + ", userId=" + userId
				+ ", userAddress=" + userAddress + ", price=" + price
				+ ", memo=" + memo + ", time=" + time + "]";
	}
	
	
}
