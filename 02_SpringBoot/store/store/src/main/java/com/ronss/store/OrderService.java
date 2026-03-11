package com.ronss.store;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired // use @Autowired to inject PaymentService in case of multiple constructors
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public OrderService() {
    }

    public void placeOrder() {

        paymentService.processPayment(100);
    }
}
