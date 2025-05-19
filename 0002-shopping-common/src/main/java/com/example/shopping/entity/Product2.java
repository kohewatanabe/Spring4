package com.example.shopping.entity;

import java.io.Serializable;

public class Product2 implements Serializable {
	private String id;
	private String name;
	private Integer price;
	private Integer stock;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getStock() {
		return this.stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
