package org.example.pattern;

/**
 * CONCRETE DECORATOR
 * 
 * This decorator adds caramel to any coffee.
 * Another example of how decorators extend functionality.
 */
public class CaramelDecorator extends CoffeeDecorator {
    
    /**
     * Constructor that wraps a coffee object
     * @param coffee The coffee to add caramel to
     */
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        // Add caramel description to the existing description
        return decoratedCoffee.getDescription() + ", with Caramel";
    }
    
    @Override
    public double getCost() {
        // Add caramel cost to the existing cost
        return decoratedCoffee.getCost() + 0.6;
    }
}
