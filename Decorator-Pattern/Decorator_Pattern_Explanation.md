# Decorator Pattern

## Overview
The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects from the same class. It provides a flexible alternative to subclassing for extending functionality.

## Intent
- Attach additional responsibilities to an object dynamically
- Provide a flexible alternative to subclassing for extending functionality
- Wrap objects to add new behavior while keeping the same interface

## Components

### 1. Component (`Coffee`)
- Defines the interface for objects that can have responsibilities added to them
- Common interface for both concrete components and decorators

### 2. Concrete Component (`SimpleCoffee`, `Espresso`)
- The original object to which additional responsibilities can be attached
- Defines the base behavior that can be decorated

### 3. Decorator (`CoffeeDecorator`)
- Maintains a reference to a Component object
- Implements the same interface as Component
- Delegates operations to the wrapped component

### 4. Concrete Decorators (`MilkDecorator`, `SugarDecorator`, etc.)
- Adds specific responsibilities to the component
- Can add state and/or behavior before or after delegating to the component

## Real-World Example
In this implementation:
- **Component**: `Coffee` interface - defines the contract for all coffee objects
- **Concrete Components**: `SimpleCoffee`, `Espresso` - base coffee types
- **Decorator**: `CoffeeDecorator` - abstract base for all decorators
- **Concrete Decorators**: `MilkDecorator`, `SugarDecorator`, `WhippedCreamDecorator`, `CaramelDecorator` - add specific extras

## Structure
```
Component (Coffee)
    ^
    |
    |--- ConcreteComponent (SimpleCoffee, Espresso)
    |
    |--- Decorator (CoffeeDecorator)
            ^
            |--- ConcreteDecoratorA (MilkDecorator)
            |--- ConcreteDecoratorB (SugarDecorator)
            |--- ConcreteDecoratorC (WhippedCreamDecorator)
            |--- ConcreteDecoratorD (CaramelDecorator)
```

## How It Works

### Step-by-Step Execution
1. Create a base component (e.g., `SimpleCoffee`)
2. Wrap it with a decorator (e.g., `MilkDecorator`)
3. Optionally wrap with more decorators (e.g., `SugarDecorator`)
4. Each decorator adds its behavior and delegates to the wrapped object

### Example Flow
```java
Coffee coffee = new SimpleCoffee();              // Base: "Simple Coffee" ($2.00)
coffee = new MilkDecorator(coffee);              // Wrap: "Simple Coffee, with Milk" ($2.50)
coffee = new SugarDecorator(coffee);             // Wrap: "Simple Coffee, with Milk, with Sugar" ($2.80)
```

## When to Use
1. You want to add responsibilities to objects dynamically and transparently
2. You need to add responsibilities that can be withdrawn
3. Extension by subclassing is impractical (would cause class explosion)
4. You want to combine several behaviors in different ways

## Advantages
- **Flexibility**: More flexible than static inheritance
- **Avoid Class Explosion**: Don't need a subclass for every combination
- **Runtime Modification**: Can add/remove responsibilities at runtime
- **Open/Closed Principle**: New decorators can be added without modifying existing code
- **Single Responsibility**: Each decorator has one specific responsibility

## Disadvantages
- **Complexity**: Many small objects can make the system harder to learn and debug
- **Order Dependency**: The order of decorators can affect behavior
- **Identity Issues**: A decorated component is not identical to the component itself
- **Configuration Overhead**: Instantiation can be complex with many layers

## Types of Decoration
1. **Additive Decoration**: Adds new behavior (most common)
2. **Filtering Decoration**: Modifies existing behavior
3. **Transparent Decoration**: Just delegates without modification

## Decorator vs Inheritance

| Aspect | Inheritance | Decorator |
|--------|-------------|-----------|
| Time | Compile-time | Runtime |
| Flexibility | Static | Dynamic |
| Combinations | Limited (class explosion) | Unlimited |
| Modification | Modifies class hierarchy | Wraps objects |

## Real-World Applications
- **Java I/O Streams**: `BufferedInputStream`, `DataInputStream` wrap `InputStream`
- **GUI Components**: Scrollbars, borders wrapping components
- **Middleware**: Request/response processing in web frameworks
- **Text Formatting**: Bold, italic, underline wrapping text
- **Game Development**: Weapon enhancements, power-ups
- **E-commerce**: Product options and add-ons

## Related Patterns
- **Adapter**: Changes interface; Decorator adds responsibilities
- **Composite**: Groups objects; Decorator adds to individual objects
- **Proxy**: Controls access; Decorator adds functionality
- **Strategy**: Changes algorithm; Decorator adds behavior

## Best Practices
1. Keep decorators lightweight and focused
2. Use abstract decorator class to reduce code duplication
3. Consider order of decoration when behavior is order-dependent
4. Document the intended stacking order if it matters
5. Be mindful of performance with deep decorator stacks
6. Consider providing convenience methods to create common combinations
