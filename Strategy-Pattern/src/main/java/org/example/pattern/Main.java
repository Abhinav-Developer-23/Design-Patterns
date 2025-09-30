package org.example.pattern;

/**
 * Strategy Pattern Demo - Payment Processing System
 * 
 * The Strategy Pattern defines a family of algorithms (payment methods),
 * encapsulates each one, and makes them interchangeable. Strategy lets
 * the algorithm vary independently from clients that use it.
 */
public class Main {
    public static void main(String[] args) {
        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to cart
        cart.addItem(new Item("Laptop", 999.99));
        cart.addItem(new Item("Mouse", 29.99));
        cart.addItem(new Item("Keyboard", 79.99));

        cart.displayCart();

        // Example 1: Pay with Credit Card
        System.out.println(">>> Paying with Credit Card <<<");
        PaymentStrategy creditCard = new CreditCardPayment(
            "1234567812345678", 
            "John Doe", 
            "123", 
            "12/25"
        );
        cart.setPaymentStrategy(creditCard);
        cart.checkout();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Add items again for next example
        cart.addItem(new Item("Monitor", 299.99));
        cart.addItem(new Item("Webcam", 89.99));
        cart.displayCart();

        // Example 2: Pay with PayPal
        System.out.println(">>> Paying with PayPal <<<");
        PaymentStrategy paypal = new PayPalPayment(
            "john.doe@example.com", 
            "securePassword123"
        );
        cart.setPaymentStrategy(paypal);
        cart.checkout();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Add items again for next example
        cart.addItem(new Item("Headphones", 149.99));
        cart.addItem(new Item("USB Cable", 12.99));
        cart.displayCart();

        // Example 3: Pay with Cryptocurrency
        System.out.println(">>> Paying with Cryptocurrency <<<");
        PaymentStrategy crypto = new CryptocurrencyPayment(
            "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", 
            "Bitcoin"
        );
        cart.setPaymentStrategy(crypto);
        cart.checkout();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Add items again for next example
        cart.addItem(new Item("Phone Case", 19.99));
        cart.displayCart();

        // Example 4: Pay with Google Pay
        System.out.println(">>> Paying with Google Pay <<<");
        PaymentStrategy googlePay = new GooglePayPayment(
            "+1-234-567-8900", 
            "john@okaxis"
        );
        cart.setPaymentStrategy(googlePay);
        cart.checkout();

        System.out.println("\n" + "=".repeat(60) + "\n");
        System.out.println("Strategy Pattern Demo Complete!");
        System.out.println("\nKey Benefits:");
        System.out.println("1. Easy to add new payment methods without modifying existing code");
        System.out.println("2. Payment logic is separated from the shopping cart");
        System.out.println("3. Payment methods can be switched at runtime");
        System.out.println("4. Follows Open/Closed Principle - open for extension, closed for modification");
    }
}
