package com.example.shopping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.example.shopping.enumeration.PaymentMethod;

@SuppressWarnings("serial")
public class Order2 implements Serializable {
	private String id;
	private List<OrderItem> orderItems;
	private LocalDateTime orderDateTime;
	private Integer billingAmount;
	private String customerName;
	private String customerAddress;
	private String customerPhone;
	private String customerEmailAddress;
	private PaymentMethod paymentMethod;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}
	
	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	
	public Integer getBillingAmount() {
		return billingAmount;
	}
	
	public void setBillingAmount(Integer billingAmount) {
		this.billingAmount = billingAmount;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAddress() {
		return this.customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerPhone() {
		return this.customerPhone;
	}
	
	public void setCustomerPhone(String customerphone) {
		this.customerPhone = customerphone;
	}
	
    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}


