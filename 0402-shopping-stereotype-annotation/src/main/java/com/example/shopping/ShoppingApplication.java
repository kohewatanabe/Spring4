package com.example.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.shopping.entity.Order;
import com.example.shopping.enumeration.PaymentMethod;
import com.example.shopping.input.CartInput;
import com.example.shopping.input.CartItemInput;
import com.example.shopping.input.OrderInput;
import com.example.shopping.service.OrderService;

@Configuration
@ComponentScan("com.example.shopping")
public class ShoppingApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShoppingApplication.class);//ShoppingApplicationはJavaConfigクラスでもあるため、
                                                                                                       //そのクラス情報を引数としてDIコンテナに渡す。DIコンテナはその設定情報
                                                                                                       //(今回であればComponentScan)に従ってBeanを探索、生成。
                                                                                                       //そして、Autowiredに従って依存性の注入を行う。
                                                                                                       //この時点で各Beanの生成と依存性の注入は済んでいる。
        OrderService orderService = context.getBean(OrderService.class);//DIコンテナの中から、OrderServiceクラスの型に収まるBeanを呼び出す。今回の場合は使用するSeiriceクラスの
                                                                        //インスタンスであるOrderServiceImplクラスのインスタンス。
        OrderInput orderInput = new OrderInput();//Service(ServiceImplクラスのインスタンス)に渡す外部からのInput情報をインスタンスとして用意している。
        orderInput.setName("東京太郎");
        orderInput.setAddress("東京都");
        orderInput.setPhone("090-0000-0000");
        orderInput.setEmailAddress("taro@example.com");
        orderInput.setPaymentMethod(PaymentMethod.CONVENIENCE_STORE);

        List<CartItemInput> cartItemInputs = new ArrayList<>();//ここもService(ServiceImplクラスのインスタンス)に渡す外部からのInput情報をインスタンスとして用意している。

        CartItemInput keshigom = new CartItemInput();
        keshigom.setProductId("p01");
        keshigom.setProductName("消しゴム");
        keshigom.setProductPrice(100);
        keshigom.setQuantity(3);
        cartItemInputs.add(keshigom);

        CartItemInput note = new CartItemInput();
        note.setProductId("p02");
        note.setProductName("ノート");
        note.setProductPrice(200);
        note.setQuantity(4);
        cartItemInputs.add(note);

        CartInput cartInput = new CartInput();//ここもService(ServiceImplクラスのインスタンス)に渡す外部からのInput情報をインスタンスとして用意している。
        cartInput.setCartItemInputs(cartItemInputs);

        Order order = orderService.placeOrder(orderInput, cartInput);//用意したInput情報を実際にServiceのビジネスロジックに渡して呼び出し、ビジネスロジックを実行する。

        System.out.println("注文確定処理が完了しました。注文ID=" + order.getId());
    }
}

