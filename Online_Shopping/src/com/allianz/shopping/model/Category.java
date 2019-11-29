package com.allianz.shopping.model;

public class Category {
private int categoryId;
private String categoryCode,cateDesc;

public String getCategoryCode() {
	return categoryCode;
}
public void setCategoryCode(String categoryCode) {
	this.categoryCode = categoryCode;
}
public String getCateDesc() {
	return cateDesc;
}
public void setCateDesc(String cateDesc) {
	this.cateDesc = cateDesc;
}


public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public Category() {
	super();
}
public Category(int categoryId, String categoryCode, String cateDesc) {
	super();
	this.categoryId = categoryId;
	this.categoryCode = categoryCode;
	this.cateDesc = cateDesc;
}
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryCode=" + categoryCode + ", cateDesc=" + cateDesc + "]";
}




}
