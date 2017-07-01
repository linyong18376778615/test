package com.iotek.entity;

public class type {
	private int typeId;					//类型编号
	private String typeName;			//类型名
	
	public type(String typeName) {
		super();
		this.typeName = typeName;
	}
	public type(){}
	public type(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "type [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
