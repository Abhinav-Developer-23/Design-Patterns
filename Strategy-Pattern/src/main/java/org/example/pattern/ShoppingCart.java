package org.example.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Context Class - Uses a PaymentStrategy to process payments
 */
public class ShoppingCart {
    private List<Item> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
            return;
        }

        if (paymentStrategy == null) {
            System.out.println("Please select a payment method.");
            return;
        }

        double total = calculateTotal();
        System.out.println("\n=== Checkout Summary ===");
        System.out.println("Items in cart:");
        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total amount: $" + total);
        System.out.println("========================\n");
        
        paymentStrategy.pay(total);
        
        System.out.println("\nThank you for your purchase!\n");
        items.clear();
    }

    public void displayCart() {
        System.out.println("\n=== Shopping Cart ===");
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Item item : items) {
                System.out.println("  - " + item.getName() + ": $" + item.getPrice());
            }
            System.out.println("Total: $" + calculateTotal());
        }
        System.out.println("====================\n");
    }
}
