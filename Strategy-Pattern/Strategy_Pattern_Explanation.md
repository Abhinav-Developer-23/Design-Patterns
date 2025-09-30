# Strategy Pattern - Payment Processing Example

## Overview
The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Problem
Imagine you have a shopping cart system that needs to support multiple payment methods (Credit Card, PayPal, Cryptocurrency, Google Pay, etc.). Without the Strategy Pattern, you might end up with:
- A large if-else or switch statement in the checkout code
- Tight coupling between the shopping cart and payment methods
- Difficulty adding new payment methods without modifying existing code

## Solution
The Strategy Pattern solves this by:
1. Defining a common interface (`PaymentStrategy`) for all payment algorithms
2. Implementing each payment method as a separate class
3. Allowing the shopping cart to use any payment strategy interchangeably

## Components

### 1. Strategy Interface
```java
PaymentStrategy.java
```
Defines the common `pay()` method that all payment strategies must implement.

### 2. Concrete Strategies
- `CreditCardPayment.java` - Handles credit card payments
- `PayPalPayment.java` - Handles PayPal payments
- `CryptocurrencyPayment.java` - Handles cryptocurrency payments
- `GooglePayPayment.java` - Handles Google Pay payments

Each concrete strategy implements the `PaymentStrategy` interface with its own payment logic.

### 3. Context
```java
ShoppingCart.java
```
- Maintains a reference to a `PaymentStrategy` object
- Allows clients to set different payment strategies at runtime
- Delegates payment processing to the selected strategy

### 4. Supporting Classes
- `Item.java` - Represents products in the cart
- `Main.java` - Demonstrates the pattern with various payment examples

## How It Works

```
┌─────────────────┐
│  ShoppingCart   │
│   (Context)     │
├─────────────────┤
│ - items         │
│ - paymentStrat. │◄─────────┐
├─────────────────┤           │
│ + checkout()    │           │
│ + setPayment()  │           │
└─────────────────┘           │
                              │
                    ┌─────────┴──────────┐
                    │ PaymentStrategy    │
                    │   (Interface)      │
                    ├────────────────────┤
                    │ + pay(amount)      │
                    └─────────┬──────────┘
                              │
        ┌─────────────────────┼─────────────────────┐
        │                     │                     │
┌───────▼──────────┐  ┌───────▼──────────┐  ┌──────▼────────────┐
│ CreditCardPayment│  │  PayPalPayment   │  │ CryptoPayment     │
├──────────────────┤  ├──────────────────┤  ├───────────────────┤
│ - cardNumber     │  │ - email          │  │ - walletAddress   │
│ - name           │  │ - password       │  │ - cryptoType      │
│ - cvv            │  ├──────────────────┤  ├───────────────────┤
├──────────────────┤  │ + pay(amount)    │  │ + pay(amount)     │
│ + pay(amount)    │  └──────────────────┘  └───────────────────┘
└──────────────────┘
```

## Benefits

1. **Open/Closed Principle**: Open for extension (add new payment methods), closed for modification (existing code unchanged)
2. **Single Responsibility**: Each payment method is in its own class
3. **Runtime Flexibility**: Payment methods can be switched at runtime
4. **Eliminates Conditionals**: No need for large if-else chains
5. **Easy Testing**: Each strategy can be tested independently

## Usage Example

```java
// Create shopping cart
ShoppingCart cart = new ShoppingCart();
cart.addItem(new Item("Laptop", 999.99));

// Choose payment method at runtime
PaymentStrategy payment = new CreditCardPayment("1234...", "John", "123", "12/25");
cart.setPaymentStrategy(payment);
cart.checkout();

// Change payment method
cart.addItem(new Item("Mouse", 29.99));
cart.setPaymentStrategy(new PayPalPayment("john@example.com", "pass"));
cart.checkout();
```

## When to Use

Use the Strategy Pattern when:
- You have multiple related classes that differ only in their behavior
- You need different variants of an algorithm
- An algorithm uses data that clients shouldn't know about
- A class defines many behaviors with multiple conditional statements

## Real-World Applications

- Payment processing systems (as demonstrated)
- Sorting algorithms (QuickSort, MergeSort, BubbleSort)
- Compression algorithms (ZIP, RAR, TAR)
- Route calculation (shortest, fastest, scenic)
- Validation strategies
- Authentication methods
- Pricing strategies (seasonal, membership-based, promotional)

## Running the Example

```bash
# Compile
cd Strategy-Pattern
mvn clean compile

# Run
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

Or compile and run manually:
```bash
javac src/main/java/org/example/pattern/*.java
java -cp src/main/java org.example.pattern.Main
```

## Key Takeaway
The Strategy Pattern is perfect when you have a family of related algorithms and want to make them interchangeable. It promotes loose coupling, enhances code maintainability, and makes adding new strategies simple without modifying existing code.
