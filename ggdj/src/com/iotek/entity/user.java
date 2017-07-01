package com.iotek.entity;

public class user {
	private int userId;				//用户ID
	private String userName;		//用户名
	private String userPass;		//用户密码
	private int userType;			//用户类型
	private String userMail;		//用户邮箱
	private String userAddress;		//用户地址
	
	public user(int userId, String userName, String userPass, int userType, String userMail, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userType = userType;
		this.userMail = userMail;
		this.userAddress = userAddress;
	}
	public user(String userName, String userPass, int userType, String userMail, String userAddress) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.userType = userType;
		this.userMail = userMail;
		this.userAddress = userAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", userName=" + userName
				+ ", userPass=" + userPass + ", userType=" + userType
				+ ", userMail=" + userMail + ", userAddress=" + userAddress
				+ "]";
	}
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String userName) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
	}
	
}