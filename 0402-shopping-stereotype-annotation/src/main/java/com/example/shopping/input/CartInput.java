package com.example.shopping.input;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")//ユーザーが入力した注文商品情報とその合計額などを保持するInput。
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
        return billingAmount;
    }

    public void setBillingAmount(Integer billingAmount) {
        this.billingAmount = billingAmount;
    }

    public List<CartItemInput> getCartItemInputs() {
        return cartItemInputs;
    }

    public void setCartItemInputs(List<CartItemInput> cartItemInputs) {
        this.cartItemInputs = cartItemInputs;
    }
}