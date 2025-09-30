# State Design Pattern - Vending Machine

## Overview

The **State Design Pattern** is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

This implementation demonstrates the State pattern using a **Vending Machine** as an example.

## Problem Statement

When building a vending machine, we need to handle different behaviors based on the machine's current state:
- When idle, it should accept money
- When it has money, it should allow product selection
- When dispensing, it should dispense the product and calculate change
- When out of stock, it should not accept money or dispense products

Without the State pattern, we would end up with complex conditional statements scattered throughout the code, making it difficult to maintain and extend.

## Solution

The State pattern encapsulates the state-specific behavior into separate state classes. The context (VendingMachine) delegates the behavior to the current state object.

## Components

### 1. State Interface (`VendingMachineState`)
Defines the interface for all concrete states with operations:
- `insertMoney(int amount)` - Insert money into the machine
- `selectProduct(String productCode)` - Select a product
- `dispenseProduct()` - Dispense the selected product
- `cancelTransaction()` - Cancel and return money
- `refillProducts()` - Refill the machine

### 2. Concrete States

#### **IdleState**
- Initial state of the vending machine
- Accepts money and transitions to HasMoneyState
- Allows refilling products
- Rejects product selection and dispensing

#### **HasMoneyState**
- Money has been inserted
- Accepts additional money
- Allows product selection if sufficient funds
- Validates product availability
- Can cancel transaction and return money
- Transitions to DispensingState on valid selection

#### **DispensingState**
- Product is being dispensed
- Completes the transaction
- Calculates and returns change
- Reduces stock
- Transitions to IdleState or OutOfStockState

#### **OutOfStockState**
- No products available
- Rejects all operations except refilling
- Transitions to IdleState when refilled

### 3. Context (`VendingMachine`)
- Maintains reference to current state
- Delegates all operations to the current state
- Manages inventory and stock
- Handles money transactions
- Provides state transition methods

### 4. Product Class
- Represents a product with code, name, and price
- Used by the vending machine inventory system

## State Diagram

```
                    ┌─────────────┐
                    │   Idle      │ ◄──────┐
                    │   State     │        │
                    └─────────────┘        │
                           │               │
                    insertMoney()          │
                           │               │
                           ▼               │
                    ┌─────────────┐        │
                    │  HasMoney   │        │
                    │   State     │        │
                    └─────────────┘        │
                           │               │
                  selectProduct()          │
                           │               │
                           ▼               │
                    ┌─────────────┐        │
                    │ Dispensing  │        │
                    │   State     │        │
                    └─────────────┘        │
                           │               │
                    dispenseProduct()      │
                           │               │
                           ├───────────────┘
                           │
                    (if out of stock)
                           │
                           ▼
                    ┌─────────────┐
                    │ OutOfStock  │
                    │   State     │
                    └─────────────┘
                           │
                    refillProducts()
                           │
                           └──────────────► IdleState
```

## Key Benefits

### 1. **Single Responsibility Principle**
Each state class handles its own behavior, making the code more focused and easier to understand.

### 2. **Open/Closed Principle**
New states can be added without modifying existing state classes or the context.

### 3. **Eliminates Complex Conditionals**
Instead of large if-else or switch statements, behavior is organized into state classes.

### 4. **Explicit State Transitions**
State transitions are clearly defined and managed, making the system flow easier to follow.

### 5. **Maintainability**
Each state is isolated, making it easier to modify behavior without affecting other states.

## Use Cases

The State pattern is useful when:
1. An object's behavior depends on its state
2. Operations have large, multipart conditional statements that depend on the object's state
3. State-specific behavior needs to be changed independently
4. State transitions are complex and need to be explicit

## Common Real-World Applications

- **Vending Machines** - Different behaviors based on money inserted, product selection, etc.
- **Order Processing Systems** - Orders go through states like Pending, Confirmed, Shipped, Delivered
- **Document Workflow** - Documents transition through Draft, Review, Approved, Published states
- **TCP Connections** - Network connections have states like Established, Listen, Closed
- **Media Players** - States like Playing, Paused, Stopped
- **Game Characters** - States like Standing, Running, Jumping, Attacking

## Example Scenarios in Our Implementation

### Scenario 1: Successful Purchase
1. User inserts $30 (Idle → HasMoney)
2. User selects Coke for $25 (HasMoney → Dispensing)
3. System dispenses product and returns $5 change (Dispensing → Idle)

### Scenario 2: Insufficient Funds
1. User inserts $20 (Idle → HasMoney)
2. User tries to select Juice for $30 (remains in HasMoney, shows error)
3. User inserts additional $15 (remains in HasMoney)
4. User selects Juice successfully (HasMoney → Dispensing → Idle)

### Scenario 3: Out of Stock
1. All products are sold (any state → OutOfStock)
2. User attempts to insert money (rejected)
3. Refill is performed (OutOfStock → Idle)

## Running the Demo

```bash
# Compile
mvn compile

# Run
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

## Class Structure

```
org.example.pattern
├── VendingMachineState (interface)
│   ├── IdleState
│   ├── HasMoneyState
│   ├── DispensingState
│   └── OutOfStockState
├── VendingMachine (context)
├── Product
└── Main (demo)
```

## Comparison with Strategy Pattern

While both State and Strategy patterns look similar, they have different intents:

| Aspect | State Pattern | Strategy Pattern |
|--------|---------------|------------------|
| **Intent** | Allow object to change behavior when state changes | Define family of interchangeable algorithms |
| **Who Controls** | Context often changes its own state | Client usually selects the strategy |
| **State Awareness** | States know about each other and transitions | Strategies are independent of each other |
| **Number of Objects** | Usually one instance per state | Can have many instances of same strategy |

## Conclusion

The State pattern is a powerful tool for managing complex state-dependent behavior. By encapsulating state-specific logic into separate classes, we create a more maintainable, testable, and extensible system. The vending machine example demonstrates how the pattern simplifies what could otherwise be a tangled mess of conditional logic.
