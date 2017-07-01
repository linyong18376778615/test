package com.iotek.entity;

public class oQuantity {
	private int oQuantityId;
	private int goodsId;
	private int quantity;
	private String orderId;	
	
	
	private String img;
	private String goodsName;
	private double goodsPrice;
	
	
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public oQuantity(int goodsId, int quantity, String orderId) {
		super();
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	public oQuantity(int oQuantityId, int goodsId, int quantity, String orderId) {
		super();
		this.oQuantityId = oQuantityId;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	public oQuantity() {
		// TODO Auto-generated constructor stub
	}
	public int getoQuantityId() {
		return oQuantityId;
	}
	public void setoQuantityId(int oQuantityId) {
		this.oQuantityId = oQuantityId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "oQuantity [oQuantityId=" + oQuantityId + ", goodsId=" + goodsId
				+ ", quantity=" + quantity + ", orderId=" + orderId + ", img="
				+ img + ", goodsName=" + goodsName + ", goodsPrice="
				+ goodsPrice + "]";
	}
	
}
