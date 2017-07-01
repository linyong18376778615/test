package com.iotek.entity;

public class text {
	public int textId;
	public String content;
	public String img;
	public String memo;
	
	
	public text(String content, String img) {
		super();
		this.content = content;
		this.img = img;
	}
	public text(){}
	public text(int testId, String content, String img) {
		super();
		this.textId = testId;
		this.content = content;
		this.img = img;
		
	}
	public int getTextId() {
		return textId;
	}
	public void setTextId(int testId) {
		this.textId = testId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getMemo(){
		return memo;
	}
	public void setMemo(String memo){
		this.memo= memo;
	}
	@Override
	public String toString() {
		return "text [textId=" + textId + ", content=" + content + ", img="
				+ img + ",memo="+memo+"]";
	}
	
}
