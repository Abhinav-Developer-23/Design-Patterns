package org.example.pattern;

/**
 * COMPONENT INTERFACE
 * 
 * This is the base interface that defines the common operations
 * for both concrete components and decorators.
 * 
 * In the Decorator Pattern, this represents the "Component" - the interface
 * that both the concrete objects and decorators will implement.
 */
public interface Coffee {
    /**
     * Get the description of the coffee
     * @return Description string
     */
    String getDescription();
    
    /**
     * Get the cost of the coffee
     * @return Cost as a double
     */
    double getCost();
}
