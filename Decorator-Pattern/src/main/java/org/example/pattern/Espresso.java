package org.example.pattern;

/**
 * CONCRETE COMPONENT
 * 
 * Another base coffee type that can be decorated.
 * Provides a different base implementation.
 */
public class Espresso implements Coffee {
    
    @Override
    public String getDescription() {
        return "Espresso";
    }
    
    @Override
    public double getCost() {
        // Base price for espresso
        return 3.0;
    }
}
