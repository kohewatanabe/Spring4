package com.example.shopping.entity;


import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderItem implements Serializable {//注文明細(注文内容)についてのentity。
    private String id;
    private String orderId;//Orderに対する外部キー(これがあることによって自分が属するOrderにアクセスできる)
    private String productId;//Productに対する外部キー(これがあることによって自分が属するProductにアクセスできる)
    private Product product;
    private Integer priceAtOrder;
    private Integer quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPriceAtOrder() {
        return priceAtOrder;
    }

    public void setPriceAtOrder(Integer priceAtOrder) {
        this.priceAtOrder = priceAtOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
