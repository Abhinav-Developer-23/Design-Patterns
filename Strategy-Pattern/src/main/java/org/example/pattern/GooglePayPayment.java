package org.example.pattern;

/**
 * Concrete Strategy - Google Pay Payment
 */
public class GooglePayPayment implements PaymentStrategy {
    private String phoneNumber;
    private String upiId;

    public GooglePayPayment(String phoneNumber, String upiId) {
        this.phoneNumber = phoneNumber;
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Google Pay Payment...");
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount paid: $" + amount);
        System.out.println("Google Pay payment successful!");
    }
}
