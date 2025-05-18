package com.example.shopping.repository;

import org.springframework.stereotype.Repository;

import com.example.shopping.entity.Order;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    @Override
    public void insert(Order order) {//本来であれば、注文データに関するデータベースとの間のやりとりが記述される。
        if (order == null) {
            throw new IllegalArgumentException("引数が不正");
        }
        System.out.println("注文を登録しました。id=" + order.getId());
    }
}
