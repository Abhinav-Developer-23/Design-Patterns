# Decorator Pattern Implementation

## 📋 Table of Contents
- [Overview](#overview)
- [Problem Statement](#problem-statement)
- [Solution](#solution)
- [Implementation Details](#implementation-details)
- [Class Diagram](#class-diagram)
- [Code Examples](#code-examples)
- [How to Run](#how-to-run)
- [Key Concepts](#key-concepts)
- [Real-World Analogies](#real-world-analogies)

## 🎯 Overview

The **Decorator Pattern** is a structural design pattern that allows you to add new functionality to objects dynamically by wrapping them in decorator objects. It provides a flexible alternative to subclassing for extending functionality.

**Pattern Type:** Structural Design Pattern  
**Difficulty Level:** ⭐⭐⭐ (Intermediate)

## ❓ Problem Statement

Imagine you're building a coffee shop ordering system:

1. You have different types of coffee (Simple Coffee, Espresso)
2. Customers can add various extras (Milk, Sugar, Whipped Cream, Caramel)
3. Each addition changes the description and price
4. Customers can combine extras in any way they want

**Problems with traditional approaches:**
- Creating a subclass for every combination would lead to **class explosion**
  - `SimpleCoffeeWithMilk`, `SimpleCoffeeWithMilkAndSugar`, `EspressoWithWhippedCream`, etc.
- Adding a new extra requires creating many new classes
- Not flexible - can't add extras dynamically at runtime

**How do we add responsibilities to objects dynamically and flexibly?**

## ✅ Solution

Use the **Decorator Pattern** to:
- Wrap objects with decorator objects that add new behavior
- Stack decorators to combine functionalities
- Maintain the same interface as the original object
- Add or remove responsibilities at runtime

```
SimpleCoffee → MilkDecorator → SugarDecorator → WhippedCreamDecorator
    $2.00         +$0.50           +$0.30              +$0.70
    = Simple Coffee, with Milk, with Sugar, with Whipped Cream ($3.50)
```

## 🏗️ Implementation Details

### Components

| Component | Role | Class/Interface |
|-----------|------|-----------------|
| **Component** | Defines interface for objects | `Coffee` |
| **Concrete Component** | Base objects to be decorated | `SimpleCoffee`, `Espresso` |
| **Decorator** | Abstract decorator base class | `CoffeeDecorator` |
| **Concrete Decorators** | Add specific responsibilities | `MilkDecorator`, `SugarDecorator`, etc. |

### File Structure

```
Decorator-Pattern/
├── src/main/java/org/example/pattern/
│   ├── Coffee.java                  # Component Interface
│   ├── SimpleCoffee.java            # Concrete Component
│   ├── Espresso.java                # Concrete Component
│   ├── CoffeeDecorator.java         # Abstract Decorator
│   ├── MilkDecorator.java           # Concrete Decorator
│   ├── SugarDecorator.java          # Concrete Decorator
│   ├── WhippedCreamDecorator.java   # Concrete Decorator
│   ├── CaramelDecorator.java        # Concrete Decorator
│   └── Main.java                    # Demo
├── README.md
└── pom.xml
```

## 📊 Class Diagram

```
┌─────────────────────────┐
│   <<interface>>         │
│      Coffee             │ (Component)
│ ─────────────────────── │
│ + getDescription(): str │
│ + getCost(): double     │
└───────────▲─────────────┘
            │ implements
      ┌─────┴─────────────────────┐
      │                           │
┌─────┴──────────┐    ┌───────────┴────────────┐
│ SimpleCoffee   │    │  CoffeeDecorator       │ (Abstract Decorator)
│                │    │  - decoratedCoffee     │
└────────────────┘    └───────────▲────────────┘
┌──────────────┐                  │ extends
│  Espresso    │        ┌─────────┴─────────────────────┐
└──────────────┘        │                               │
                  ┌─────┴──────────┐            ┌───────┴──────────┐
                  │ MilkDecorator  │            │ SugarDecorator   │
                  └────────────────┘            └──────────────────┘
                  ┌──────────────────────┐      ┌──────────────────┐
                  │WhippedCreamDecorator │      │ CaramelDecorator │
                  └──────────────────────┘      └──────────────────┘
```

## 💻 Code Examples

### 1. Component Interface

```java
public interface Coffee {
    String getDescription();
    double getCost();
}
```

### 2. Concrete Component

```java
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        return 2.0;
    }
}
```

### 3. Abstract Decorator

```java
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
```

### 4. Concrete Decorator

```java
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", with Milk";
    }
    
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}
```

### 5. Usage Example

```java
// Start with simple coffee
Coffee coffee = new SimpleCoffee();

// Add milk
coffee = new MilkDecorator(coffee);

// Add sugar
coffee = new SugarDecorator(coffee);

// Add whipped cream
coffee = new WhippedCreamDecorator(coffee);

System.out.println(coffee.getDescription()); 
// Output: Simple Coffee, with Milk, with Sugar, with Whipped Cream

System.out.println(coffee.getCost()); 
// Output: 3.5
```

## 🚀 How to Run

### Prerequisites
- Java 17 or higher
- Maven (optional)

### Running the Demo

**Option 1: Using Maven**
```bash
cd Decorator-Pattern
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.pattern.Main"
```

**Option 2: Using Java directly**
```bash
cd Decorator-Pattern/src/main/java
javac org/example/pattern/*.java
java org.example.pattern.Main
```

### Expected Output

```
=== Decorator Pattern Demo - Coffee Shop ===

--- Order 1: Simple Coffee ---
Description: Simple Coffee
Cost: $2.00

--- Order 2: Simple Coffee with Milk ---
Description: Simple Coffee, with Milk
Cost: $2.50

--- Order 3: Simple Coffee with Milk and Sugar ---
Description: Simple Coffee, with Milk, with Sugar
Cost: $2.80

--- Order 4: Espresso with Whipped Cream and Caramel ---
Description: Espresso, with Whipped Cream, with Caramel
Cost: $4.30

--- Order 5: Fully Loaded Coffee ---
Description: Simple Coffee, with Milk, with Sugar, with Whipped Cream, with Caramel
Cost: $4.10

--- Order 6: Complex Order (Inline Creation) ---
Description: Espresso, with Milk, with Whipped Cream, with Caramel
Cost: $4.80

=== Demo Complete ===

Key Takeaways:
1. Decorators can be stacked in any order
2. Each decorator adds its own behavior and cost
3. The original object remains unchanged
4. New decorators can be added without modifying existing code
```

## 🔑 Key Concepts

### 1. Decorator vs Inheritance

| Aspect | Inheritance | Decorator |
|--------|-------------|-----------|
| **Flexibility** | Static (compile-time) | Dynamic (runtime) |
| **Combinations** | Limited (class explosion) | Unlimited |
| **Modification** | Modifies class | Wraps object |
| **Extensibility** | Difficult to extend | Easy to add new decorators |

### 2. Key Characteristics

✅ **Decorator IS-A Component** (implements same interface)  
✅ **Decorator HAS-A Component** (wraps a component)  
✅ **Decorators can be stacked** (nested wrapping)  
✅ **Transparent to client** (same interface as component)

### 3. When to Use Decorator Pattern

✅ **Use when:**
- You need to add responsibilities to objects dynamically
- You want to avoid class explosion from inheritance
- You need to add/remove responsibilities at runtime
- Extending by subclassing is impractical
- You want to combine different behaviors

❌ **Don't use when:**
- You need to change the core functionality (use Strategy instead)
- Simple inheritance is sufficient
- You need to alter the interface (use Adapter instead)
- Performance is critical (decorators add overhead)

### 4. Design Principles

- **Open/Closed Principle**: Open for extension, closed for modification
- **Single Responsibility Principle**: Each decorator has one responsibility
- **Composition over Inheritance**: Uses wrapping instead of subclassing
- **Liskov Substitution Principle**: Decorators can replace components

## 🌍 Real-World Analogies

### 1. Getting Dressed
You start with your body (component) and add layers of clothing (decorators):
```
Body → Underwear → Shirt → Sweater → Jacket
```
Each layer adds functionality (warmth, style) without changing what's underneath.

### 2. Pizza Toppings
Start with a base pizza and add toppings:
```
Plain Pizza ($8) → + Cheese ($1) → + Pepperoni ($2) → + Mushrooms ($1.5) = $12.50
```

### 3. Text Formatting
Apply formatting to text:
```
"Hello" → Bold → Italic → Underline → <u><i><b>Hello</b></i></u>
```

### 4. Java I/O Streams
Classic example from Java standard library:
```java
InputStream in = new FileInputStream("file.txt");
in = new BufferedInputStream(in);
in = new GZIPInputStream(in);
```

## 📚 Real-World Applications

### 1. Java I/O Streams
```java
BufferedReader reader = new BufferedReader(
    new InputStreamReader(
        new FileInputStream("file.txt")
    )
);
```

### 2. GUI Components
```java
JScrollPane scrollPane = new JScrollPane(textArea);
Border border = BorderFactory.createLineBorder(Color.BLACK);
scrollPane.setBorder(border);
```

### 3. Web Frameworks
- Request/Response decorators (logging, authentication, compression)
- Middleware in Express.js, Django

### 4. Game Development
```java
Weapon sword = new BasicSword();
sword = new FireEnchantment(sword);
sword = new PoisonEnchantment(sword);
```

## 🆚 Related Patterns

### Decorator vs Adapter
- **Decorator**: Adds functionality, same interface
- **Adapter**: Changes interface, same functionality

### Decorator vs Composite
- **Decorator**: Adds responsibilities to single object
- **Composite**: Treats groups of objects uniformly

### Decorator vs Proxy
- **Decorator**: Adds behavior
- **Proxy**: Controls access

### Decorator vs Strategy
- **Decorator**: Adds to the outside (wrapping)
- **Strategy**: Changes from the inside (algorithm)

## 🎓 Learning Points

1. **Decorators wrap objects** - they don't replace them
2. **Same interface** - decorators implement the same interface as components
3. **Runtime flexibility** - add/remove decorators dynamically
4. **Avoid class explosion** - better than creating subclass for every combination
5. **Composition over inheritance** - uses "has-a" instead of "is-a"
6. **Order matters** - different stacking order can produce different results

## ⚠️ Considerations

### Advantages
✅ More flexible than static inheritance  
✅ Avoids feature-laden classes high up in the hierarchy  
✅ Responsibilities can be added/removed at runtime  
✅ Easy to add new decorators  
✅ Follows Open/Closed Principle

### Disadvantages
❌ Many small objects can make debugging harder  
❌ Decorators can make code harder to understand  
❌ Order of decorators can matter  
❌ Can be complex to remove a specific decorator from the stack  
❌ Additional overhead from wrapping

## 📖 Further Reading

- [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns) (Gang of Four)
- [Refactoring Guru - Decorator Pattern](https://refactoring.guru/design-patterns/decorator)
- [Java I/O Streams - Real-world Decorator Example](https://docs.oracle.com/javase/tutorial/essential/io/streams.html)

## 📝 License

This is an educational project demonstrating the Decorator Design Pattern.

---

**Created as part of Design Patterns learning series**  
For more patterns, check the parent directory!
