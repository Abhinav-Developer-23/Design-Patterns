package org.example.pattern;

/**
 * Concrete Strategy - PayPal Payment
 */
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal Payment...");
        System.out.println("Logging in with email: " + email);
        System.out.println("Amount paid: $" + amount);
        System.out.println("PayPal payment successful!");
    }
}
