package com.ronss.store;

// @Service
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.printf("Amount: %.2f ", amount);
    }
}
