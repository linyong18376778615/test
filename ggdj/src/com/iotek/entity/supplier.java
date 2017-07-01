package com.iotek.entity;

public class supplier {
	private int supplierId;						//供应商ID
	private String supplierName;				//供应商名称
	private String supplierAddress;				//供应商地址
	private String suImg;                       //供应商图片
	private String suTel;                       //供应商电话
	private String suFruit;                     //供应水果
	
	public supplier(String supplierName, String supplierAddress, String suImg,
			String suTel, String suFruit) {
		super();
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.suImg = suImg;
		this.suTel = suTel;
		this.suFruit = suFruit;
	}
	
	public supplier(int supplierId,String supplierName, String supplierAddress, String suImg,
			String suTel, String suFruit) {
		this.supplierId=supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.suImg = suImg;
		this.suTel = suTel;
		this.suFruit = suFruit;
	}


	public supplier() {
		// TODO Auto-generated constructor stub
	}

	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSuImg(){
		return suImg;
	}
	public void setSuImg(String suImg){
		this.suImg=suImg;
	}
	
	public String getSuTel(){
		return suTel;
	}
	public void setSuTel(String suTel){
		this.suTel=suTel;
	}
	
	public String getSuFruit(){
		return suFruit;
	}
	public void setSuFruit(String suFruit){
		this.suFruit=suFruit;
	}
	@Override
	public String toString() {
		return "supplier [supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", supplierAddress=" + supplierAddress
				+ ", suImg=" + suImg + ", suTel=" + suTel + ", suFruit="
				+ suFruit + "]";
	}
	
	
}
