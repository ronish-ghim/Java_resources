package com.ronss.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(StoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		// orderService.setPaymentService(context.getBean(PaymentService.class));
		// var orderService = new OrderService(new PaypalPaymentService());

		orderService.placeOrder();
	}

}
