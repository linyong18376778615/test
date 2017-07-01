package com.iotek.entity;

public class trolley {
	
	private int trolleyId;				//购物车id
	private String userName;			//用户名
	private float price;				//商品价格

	public trolley(String userName, float price) {
		super();
		this.userName = userName;
		this.price = price;
	}
	public trolley(int trolleyId, String userName, float price) {
		super();
		this.trolleyId = trolleyId;
		this.userName = userName;
		this.price = price;
	}
	public int gettrolleyId() {
		return trolleyId;
	}
	public void settrolleyId(int trolleyId) {
		this.trolleyId = trolleyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public trolley() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "trolley [trolleyId=" + trolleyId + ", userName=" + userName
				+ ", price=" + price + "]";
	}
	
}
