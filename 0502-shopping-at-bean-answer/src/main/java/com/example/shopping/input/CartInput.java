package com.example.shopping.input;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class CartInput implements Serializable {
	private Integer totalAmount;
	private Integer billingAmount;
	private List<CartItemInput> cartItemInputs;
	//このインプットの情報だけで、商品購入情報は表現できそうだが、なぜCartItemInputを送るのか。
	//AIの回答だとあまりCartItemInputを単体で送る意味はなさそう。
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
		return this.cartItemInputs;
	}
	
	public void setCartItemInputs(List<CartItemInput> cartItemInputs) {
		this.cartItemInputs = cartItemInputs;
	}
}