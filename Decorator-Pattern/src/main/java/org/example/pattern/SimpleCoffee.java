package org.example.pattern;

/**
 * CONCRETE COMPONENT
 * 
 * This is the base implementation that can be decorated.
 * It provides the basic functionality without any additions.
 * 
 * This represents the core object to which additional responsibilities
 * can be attached dynamically.
 */
public class SimpleCoffee implements Coffee {
    
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    
    @Override
    public double getCost() {
        // Base price for simple coffee
        return 2.0;
    }
}
