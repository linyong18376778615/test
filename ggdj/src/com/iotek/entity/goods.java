package com.iotek.entity;

public class goods {
	private int goodsId;					//商品编号
	private String goodsName;				//商品名称
	private int typeId;					//商品类别
	private String goodsDescription;		//商品描述
	private int supplierId;				//供应商id
	private double goodsPrice;				//商品价格
	private String img;                     //商品图片
	public goods(int goodsId, String goodsName, int typeId, String goodsDescription, int supplierId,
			double goodsPrice, String img) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.typeId = typeId;
		this.goodsDescription = goodsDescription;
		this.supplierId = supplierId;
		this.goodsPrice = goodsPrice;
		this.img = img;
	}

	public goods() {
		// TODO Auto-generated constructor stub
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getGoodsDescription() {
		return goodsDescription;
	}
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId){
		this.supplierId=supplierId;
	}
	@Override
	public String toString() {
		return "goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", typeId=" + typeId + ", goodsDescription="
				+ goodsDescription + ", supplierId=" + supplierId
				+ ", goodsPrice=" + goodsPrice + ", img=" + img + "]";
	}
	public double getGoodsPrice() {
		// TODO Auto-generated method stub
		return goodsPrice;
	}
	
	public void setGoodsPrice(double goodsPrice){
		this.goodsPrice=goodsPrice;
	}
	public String getImg() {
		// TODO Auto-generated method stub
		return img;
	}
	public void setImg(String img){
		this.img=img;
	}
}