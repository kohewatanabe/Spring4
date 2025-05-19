package com.example.shopping.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.Order;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.OrderInput;
import com.example.shopping.repository.OrderItemRepository;
import com.example.shopping.repository.OrderRepository;
import com.example.shopping.repository.ProductRepository;
//entityにInputを入れているのが腑に落ちないため、とりあえずInputを全て写経し、Controller(main関数)にも取り掛かる。その後、この構造について考える。次やることはCartInputの写経。
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
		//Repositoryに渡す注文オブジェクトを生成
		Order order = new Order();
		// IDはUUID(Universally Unique Identifier。ランダムなIDを生成する際に用いられる標準的な仕組み)を使用
		order.setId(UUID.randomUUID().toString());
		//引数で渡された注文情報(OrderInput)の情報をOrderオブジェクトに格納
		order.setCustomerName(orderInput.getName());
		order.setCustomerAddress(orderInput.getAddress());
		order.setCustomerPhone(orderInput.getEmailAddress());
		order.setOrderDateTime(LocalDateTime.now());
		order.setPaymentMethod(orderInput.getPaymentMethod());
		
		
	}
}
