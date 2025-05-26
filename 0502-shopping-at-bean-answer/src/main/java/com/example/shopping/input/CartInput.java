package com.example.shopping.input;

import java.io.Serializable;
import java.util.List;
//import com.example.shopping.input.CartItemInput;

@SuppressWarnings("serial")
public class CartInput implements Serializable {
	private Integer totalAmount;
	private Integer billingAmount;
	private List<CartItemInput> cartItemInputs;
	
	public Integer getTotalAmount() {
		return totalAmount;
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
	
	public List<CartItemInput> getCartItemInput() {
		return this.cartItemInputs;
	}
	
	public void setCartItemInput(List<CartItemInput> cartItemInput) {
		this.cartItemInputs = cartItemInput;
	}
}
