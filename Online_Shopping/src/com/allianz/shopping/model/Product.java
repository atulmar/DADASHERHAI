package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
private int productId;
private String productCode;
private String description;
private float price;
private Date munfDate;
List<Category> categoryList=new ArrayList<Category>();

public List<Category> getCategoryList() {
	return categoryList;
}

public void setCategoryList(List<Category> categoryList) {
	this.categoryList = categoryList;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductCode() {
	return productCode;
}
public void setProductCode(String productCode) {
	this.productCode = productCode;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}

public Product(int productId, String productCode, String description, float price, Date munfDate) {
	super();
	this.productId = productId;
	this.productCode = productCode;
	this.description = description;
	this.price = price;
	this.munfDate = munfDate;
}
public Date getMunfDate() {
	return munfDate;
}
public void setMunfDate(Date munfDate) {
	this.munfDate = munfDate;
}
public Product() {
	super();
}

}
