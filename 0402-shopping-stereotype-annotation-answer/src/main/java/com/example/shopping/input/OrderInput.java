package com.example.shopping.input;

import java.io.Serializable;

import com.example.shopping.enumeration.PaymentMethod;

@SuppressWarnings("serial")
public class OrderInput implements Serializable {
	private String name;
	private String address;
	private String phone;
	private String emailAddress;
	private PaymentMethod paymentMethod;
	
	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
