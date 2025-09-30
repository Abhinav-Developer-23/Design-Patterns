package org.example.pattern;

/**
 * DECORATOR PATTERN DEMONSTRATION
 * 
 * This example demonstrates the Decorator Pattern where:
 * - Coffee (Component) defines the interface for objects that can have responsibilities added
 * - SimpleCoffee, Espresso (Concrete Components) are the base objects to be decorated
 * - CoffeeDecorator (Decorator) maintains a reference to a Component and implements the same interface
 * - MilkDecorator, SugarDecorator, etc. (Concrete Decorators) add specific responsibilities
 * 
 * The pattern allows us to add new functionality to objects dynamically by wrapping them
 * in decorator objects, without modifying the original class.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo - Coffee Shop ===\n");
        
        // Example 1: Simple Coffee (no decorations)
        System.out.println("--- Order 1: Simple Coffee ---");
        Coffee coffee1 = new SimpleCoffee();
        printCoffee(coffee1);
        
        // Example 2: Simple Coffee with Milk
        System.out.println("\n--- Order 2: Simple Coffee with Milk ---");
        Coffee coffee2 = new SimpleCoffee();
        coffee2 = new MilkDecorator(coffee2);
        printCoffee(coffee2);
        
        // Example 3: Simple Coffee with Milk and Sugar
        System.out.println("\n--- Order 3: Simple Coffee with Milk and Sugar ---");
        Coffee coffee3 = new SimpleCoffee();
        coffee3 = new MilkDecorator(coffee3);
        coffee3 = new SugarDecorator(coffee3);
        printCoffee(coffee3);
        
        // Example 4: Espresso with Whipped Cream and Caramel
        System.out.println("\n--- Order 4: Espresso with Whipped Cream and Caramel ---");
        Coffee coffee4 = new Espresso();
        coffee4 = new WhippedCreamDecorator(coffee4);
        coffee4 = new CaramelDecorator(coffee4);
        printCoffee(coffee4);
        
        // Example 5: Fully Loaded Coffee (all decorators)
        System.out.println("\n--- Order 5: Fully Loaded Coffee ---");
        Coffee coffee5 = new SimpleCoffee();
        coffee5 = new MilkDecorator(coffee5);
        coffee5 = new SugarDecorator(coffee5);
        coffee5 = new WhippedCreamDecorator(coffee5);
        coffee5 = new CaramelDecorator(coffee5);
        printCoffee(coffee5);
        
        // Example 6: Creating a complex order inline
        System.out.println("\n--- Order 6: Complex Order (Inline Creation) ---");
        Coffee coffee6 = new CaramelDecorator(
                            new WhippedCreamDecorator(
                                new MilkDecorator(
                                    new Espresso()
                                )
                            )
                         );
        printCoffee(coffee6);
        
        System.out.println("\n=== Demo Complete ===");
        System.out.println("\nKey Takeaways:");
        System.out.println("1. Decorators can be stacked in any order");
        System.out.println("2. Each decorator adds its own behavior and cost");
        System.out.println("3. The original object remains unchanged");
        System.out.println("4. New decorators can be added without modifying existing code");
    }
    
    /**
     * Helper method to print coffee details
     * @param coffee The coffee object to print
     */
    private static void printCoffee(Coffee coffee) {
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee.getCost()));
    }
}