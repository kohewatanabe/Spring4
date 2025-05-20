package com.example.shopping.input;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CartInput implements Serializable {
	private Integer totalAmount;
	private Integer billingAmount;
	private List<CartItemInput> cartItemInput;
	
	public Integer getTotalAmount() {
		return this.totalAmount;
	}
	
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Integer getBillingAmount() {
		return this.billingAmount;
	}
	
	public void setBillingAmount(Integer billingAmount) {
		this.billingAmount = billingAmount;
	}
	
	public List<CartItemInput> getCartItemInputs() {
		return this.cartItemInput;
	}
	
	public void setCartItemInputs(List<CartItemInput> cartItemInput) {
		this.cartItemInput = cartItemInput;
	}
}
