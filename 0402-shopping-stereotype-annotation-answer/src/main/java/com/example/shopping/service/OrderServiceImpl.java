package com.example.shopping.service;
//Orderが注文した人の名前やメアドなどで、OrderItemがその注文に紐づいた、実際に注文した内容で、Productがデータベースに格納されている各商品の情報(在庫状況など)
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.entity.Order;
import com.example.shopping.entity.OrderItem;
import com.example.shopping.entity.Product;
import com.example.shopping.exception.StockShortageException;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.CartItemInput;
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
		Order order = new Order();//InputからEntityを作成する(新しいデータを作成して登録するシナリオ)。
		// IDはUUID(Universally Unique Identifier。ランダムなIDを生成する際に用いられる標準的な仕組み)を使用
		order.setId(UUID.randomUUID().toString());
		//引数で渡された注文情報(OrderInput)の情報をOrderオブジェクトに格納
		order.setCustomerName(orderInput.getName());
		order.setCustomerAddress(orderInput.getAddress());
		order.setCustomerPhone(orderInput.getEmailAddress());
		order.setOrderDateTime(LocalDateTime.now());
		order.setPaymentMethod(orderInput.getPaymentMethod());
		//合計額（税抜）を計算
		int totalAmount = calculateTotalAmount(cartInput.getCartItemInputs());
		//請求額(税込)を計算
		int billingAmount = calculateTax(totalAmount);
		order.setBillingAmount(billingAmount);
		//注文データをデータベースに格納
		orderRepository.insert(order);
		List<OrderItem> orderItems = new ArrayList<>();
		//カートの中の商品の数だけ繰り返す(カートの中の商品データだけを取り出す)
		for (CartItemInput cartItem : cartInput.getCartItemInputs()) {
			//商品データをデータベースから取得
			Product product = productRepository.selectById(cartItem.getProductId());//Repository層に依頼してデータベースから既存のEntityを読み込む(既存のデータを操作するシナリオ)。この場合RepositoryでEntityを作らないといけない。
			int afterStock = product.getStock() - cartItem.getQuantity();
			//在庫が足りない場合は例外をスローする
			if (afterStock < 0) {
				throw new StockShortageException("在庫が足りません");
			}
			//商品在庫数を更新
			product.setStock(afterStock);
			//データベースの商品データを更新する。
			productRepository.update(product);
			//Repositoryに渡す注文明細オブジェクトを生成。
			//ここから
		}
	}
		
	private int calculateTotalAmount(List<CartItemInput> cartItems) {
		int totalAmount = 0;
		for (CartItemInput cartItem : cartItems) {
			totalAmount += (cartItem.getProductPrice() * cartItem.getQuantity());
		}
		return totalAmount;
	}
	
	private int calculateTax(int price) {
		return (int)(price * 1.1);
	}
}
