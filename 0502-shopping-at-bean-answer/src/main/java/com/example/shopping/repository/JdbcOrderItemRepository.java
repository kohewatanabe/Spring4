package com.example.shopping.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.shopping.entity.OrderItem;

@Repository
public class JdbcOrderItemRepository implements OrderItemRepository {
	private final DataSource dataSource;
	
	@Autowired
	public JdbcOrderItemRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(OrderItem orderItem) {
		try (
			Connection con = dataSource.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into t_order_item values (?, ?, ?, ?, ?)");
			
			) {
			stmt.setString(1,  orderItem.getId());
			stmt.setString(2, orderItem.getOrderId());
			stmt.setString(3, orderItem.getProductId());
			stmt.setInt(4,  orderItem.getPriceAtOrder());
			stmt.setInt(5,  orderItem.getQuantity());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("INSERTに失敗", e);
		}
	}
}
