package org.example.pattern;

/**
 * CONCRETE DECORATOR
 * 
 * This decorator adds sugar to any coffee.
 * Demonstrates how multiple decorators can be applied to the same object.
 */
public class SugarDecorator extends CoffeeDecorator {
    
    /**
     * Constructor that wraps a coffee object
     * @param coffee The coffee to add sugar to
     */
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        // Add sugar description to the existing description
        return decoratedCoffee.getDescription() + ", with Sugar";
    }
    
    @Override
    public double getCost() {
        // Add sugar cost to the existing cost
        return decoratedCoffee.getCost() + 0.3;
    }
}
