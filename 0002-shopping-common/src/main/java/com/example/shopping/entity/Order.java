package com.example.shopping.entity;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.example.shopping.enumeration.PaymentMethod;

@SuppressWarnings("serial")//注文テーブルに対応したentity。注文者の情報。
public class Order implements Serializable {
    private String id;
    private List<OrderItem> orderItems;//関連するOrderItemをフィールドに保持(これがあることによってOrder側から関係するOrderItemを参照できる)。本来はOrderItemのOrderIdのみでいいが、双方向でアクセスできるようにしている。
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
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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
