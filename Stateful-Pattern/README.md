# State Pattern - Vending Machine

A comprehensive implementation of the **State Design Pattern** using a vending machine simulation.

## What is the State Pattern?

The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class. It's particularly useful when an object's behavior depends on its state, and it must change behavior at runtime depending on that state.

## Project Structure

```
Stateful-Pattern/
├── src/main/java/org/example/pattern/
│   ├── VendingMachineState.java    # State interface
│   ├── IdleState.java              # Idle state implementation
│   ├── HasMoneyState.java          # Has money state implementation
│   ├── DispensingState.java        # Dispensing state implementation
│   ├── OutOfStockState.java        # Out of stock state implementation
│   ├── VendingMachine.java         # Context class
│   ├── Product.java                # Product model
│   └── Main.java                   # Demo application
├── State_Pattern_Explanation.md    # Detailed explanation
├── README.md                        # This file
└── pom.xml                          # Maven configuration
```

## States

### 1. **Idle State**
- Waiting for money to be inserted
- Accepts money and transitions to HasMoneyState
- Allows product refilling

### 2. **Has Money State**
- Money has been inserted
- Accepts product selection
- Validates funds and availability
- Can cancel transaction

### 3. **Dispensing State**
- Actively dispensing a product
- Calculates and returns change
- Updates inventory
- Transitions based on stock availability

### 4. **Out of Stock State**
- No products available
- Rejects all operations except refilling
- Returns to Idle state when refilled

## Features

✅ Complete state machine implementation  
✅ Money and inventory management  
✅ Change calculation  
✅ Stock tracking  
✅ Transaction cancellation  
✅ Product refilling  
✅ Comprehensive error handling  
✅ Multiple demonstration scenarios  

## How to Run

### Prerequisites
- Java 17 or higher
- Maven

### Compile and Run

```bash
# Compile the project
mvn compile

# Run the demo
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

### Alternative (without Maven)

```bash
# Compile
javac -d target/classes src/main/java/org/example/pattern/*.java

# Run
java -cp target/classes org.example.pattern.Main
```

## Demo Scenarios

The demo includes 9 different scenarios:

1. **Successful Purchase** - Normal transaction flow
2. **Insufficient Funds** - Handling when money is not enough
3. **Cancel Transaction** - Returning money to user
4. **Invalid Product Code** - Error handling
5. **Depleting Stock** - Multiple purchases
6. **Out of Stock** - Attempting to use when empty
7. **Refill Products** - Restocking the machine
8. **Purchase After Refill** - Normal operation after restock
9. **Invalid Operations** - Testing state constraints

## Key Concepts Demonstrated

- **State Encapsulation**: Each state class handles its own behavior
- **State Transitions**: Clear transitions between states
- **Context Management**: VendingMachine delegates to current state
- **Single Responsibility**: Each class has one reason to change
- **Open/Closed Principle**: Easy to add new states without modifying existing code

## Benefits of This Pattern

1. **Eliminates Complex Conditionals** - No large if-else or switch statements
2. **Easier Maintenance** - State-specific logic is isolated
3. **Better Organization** - Clear separation of concerns
4. **Explicit Transitions** - State changes are well-defined
5. **Extensibility** - New states can be added easily

## When to Use State Pattern

- Object behavior depends on its state
- Operations have large conditional statements based on state
- State transitions are complex and need to be explicit
- You want to avoid duplication of state-specific code

## Related Patterns

- **Strategy Pattern** - Similar structure but different intent
- **Command Pattern** - Can be used with State for action encapsulation
- **Singleton Pattern** - States can be implemented as singletons

## Learn More

See [State_Pattern_Explanation.md](State_Pattern_Explanation.md) for a detailed explanation including:
- State diagrams
- UML class diagrams
- Comparison with other patterns
- Real-world applications
- Best practices

## License

This is a educational demonstration project for learning design patterns.
