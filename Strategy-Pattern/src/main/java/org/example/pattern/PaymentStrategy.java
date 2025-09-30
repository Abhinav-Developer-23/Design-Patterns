package org.example.pattern;

/**
 * Strategy Interface - defines the common interface for all payment strategies
 */
public interface PaymentStrategy {
    void pay(double amount);
}
