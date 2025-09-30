package org.example.pattern;

/**
 * CONCRETE DECORATOR
 * 
 * This decorator adds milk to any coffee.
 * It extends the base decorator and adds its own behavior.
 * 
 * The decorator:
 * 1. Wraps the original coffee object
 * 2. Adds "with Milk" to the description
 * 3. Adds the milk cost to the total cost
 */
public class MilkDecorator extends CoffeeDecorator {
    
    /**
     * Constructor that wraps a coffee object
     * @param coffee The coffee to add milk to
     */
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        // Add milk description to the existing description
        return decoratedCoffee.getDescription() + ", with Milk";
    }
    
    @Override
    public double getCost() {
        // Add milk cost to the existing cost
        return decoratedCoffee.getCost() + 0.5;
    }
}
