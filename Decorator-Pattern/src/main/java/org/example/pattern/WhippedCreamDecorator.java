package org.example.pattern;

/**
 * CONCRETE DECORATOR
 * 
 * This decorator adds whipped cream to any coffee.
 * Shows how decorators can be stacked to create complex combinations.
 */
public class WhippedCreamDecorator extends CoffeeDecorator {
    
    /**
     * Constructor that wraps a coffee object
     * @param coffee The coffee to add whipped cream to
     */
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        // Add whipped cream description to the existing description
        return decoratedCoffee.getDescription() + ", with Whipped Cream";
    }
    
    @Override
    public double getCost() {
        // Add whipped cream cost to the existing cost
        return decoratedCoffee.getCost() + 0.7;
    }
}
