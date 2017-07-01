package com.iotek.entity;


public class tQuantity {
	private int tQuantityId;				//数量表id
	private int goodsId;					//商品id
	private int quantity;					//商品数量
	private int trolleyId;					//购物车id
	public tQuantity(int goodsId, int quantity, int trolleyId) {
		super();
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.trolleyId = trolleyId;
	}
	public tQuantity(int tQuantityId, int goodsId, int quantity, int trolleyId) {
		super();
		this.tQuantityId = tQuantityId;
		this.goodsId = goodsId;
		this.quantity = quantity;
		this.trolleyId = trolleyId;
	}
	public int gettQuantityId() {
		return tQuantityId;
	}
	public void settQuantityId(int tQuantityId) {
		this.tQuantityId = tQuantityId;
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
	public int getTrolleyId() {
		return trolleyId;
	}
	public void setTrolleyId(int trolleyId) {
		this.trolleyId = trolleyId;
	}

	@Override
	public String toString() {
		return "tQuantity [tQuantityId=" + tQuantityId + ", goodsId=" + goodsId
				+ ", quantity=" + quantity + ", trolleyId=" + trolleyId + "]";
	}
	
}
