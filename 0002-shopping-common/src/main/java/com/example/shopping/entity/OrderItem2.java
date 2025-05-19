package com.example.shopping.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderItem2 implements Serializable {
	private String id;
	private String orderId;
	private String productId;
	private Product product;
	private Integer priceAtOrder;
	private Integer quantity;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getProductId() {
		return this.productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer priceAtOrder() {
		return this.priceAtOrder;
	}
	
	public void setPriceAtOrder(Integer priceAtOrder) {
		this.priceAtOrder = priceAtOrder;
	}
	
	public Integer getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
