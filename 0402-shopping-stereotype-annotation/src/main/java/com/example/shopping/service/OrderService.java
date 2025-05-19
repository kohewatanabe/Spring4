package com.example.shopping.service;

import com.example.shopping.entity.Order;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.OrderInput;

public interface OrderService {
    Order placeOrder(OrderInput orderInput, CartInput cartInput);//Controllerからユーザーが入力した情報を受けとって、Controllerに処理した業務データを返す。
}
