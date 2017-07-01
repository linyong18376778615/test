package com.iotek.entity;

public class record {
	private int recordId;					//订单记录号
	private int orderId;					//订单号
	private float price;					//价格
	private String userName;				//用户名
	public record(int orderId, float price, String userName) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.userName = userName;
	}
	public record(int recordId, int orderId, float price, String userName) {
		super();
		this.recordId = recordId;
		this.orderId = orderId;
		this.price = price;
		this.userName = userName;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "record [recordId=" + recordId + ", orderId=" + orderId
				+ ", price=" + price + ", userName=" + userName + "]";
	}
	
}
