package com.example.shopping.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.Order;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.OrderInput;
import com.example.shopping.repository.OrderItemRepository;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final ProductRepository productRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
		
	this.orderRepository = orderRepository;
	this.orderItemRepository = orderItemRepository;
	this.productRepository = productRepository;
	}
	
	@Override
	public Order placeOrder(OrderInput orderInput, CartInput cartInput) {
		Order order = new Order();
		
		order.setId(UUID.random().toString());
	}
}


