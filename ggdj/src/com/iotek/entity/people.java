package com.iotek.entity;

public class people {
	private int peopleId;
	private String peopleType;
	private int minNumber;
	private int maxNumber;
	private String morning;
	private String lunch;
	private String evening;
	private String advice;

	


	public people(int peopleId,String peopleType, int minNumber, int maxNumber,
			String morning, String lunch, String evening, String advice) {
		super();
		this.peopleId=peopleId;
		this.peopleType = peopleType;
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
		this.morning = morning;
		this.lunch = lunch;
		this.evening = evening;
		this.advice = advice;

	}

	public people() {
		// TODO Auto-generated constructor stub
	}

	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}
	public String getPeopleType() {
		return peopleType;
	}
	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}
	public int getMinNumber() {
		return minNumber;
	}
	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getEvening() {
		return evening;
	}
	public void setEvening(String evening) {
		this.evening = evening;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Override
	public String toString() {
		return "people [peopleId=" + peopleId + ", peopleType=" + peopleType
				+ ", minNumber=" + minNumber + ", maxNumber=" + maxNumber
				+ ", morning=" + morning + ", lunch=" + lunch + ", evening="
				+ evening + ", advice=" + advice + "]";
	}

	
	
}
