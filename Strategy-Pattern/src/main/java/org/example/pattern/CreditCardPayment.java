package org.example.pattern;

/**
 * Concrete Strategy - Credit Card Payment
 */
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String name, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Cardholder: " + name);
        System.out.println("Amount paid: $" + amount);
        System.out.println("Credit Card payment successful!");
    }

    private String maskCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
