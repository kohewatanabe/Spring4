package com.example.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
