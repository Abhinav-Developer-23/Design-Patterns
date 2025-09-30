package org.example.pattern;

/**
 * ABSTRACT DECORATOR
 * 
 * This is the base decorator class that implements the Component interface
 * and contains a reference to a Component object.
 * 
 * This class maintains a reference to the component it decorates and
 * delegates all operations to it by default. Concrete decorators will
 * override these methods to add their own behavior.
 * 
 * Key Point: The decorator "has-a" component and "is-a" component
 */
public abstract class CoffeeDecorator implements Coffee {
    
    // Reference to the component being decorated
    protected Coffee decoratedCoffee;
    
    /**
     * Constructor that accepts the component to be decorated
     * @param coffee The coffee object to decorate
     */
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    
    /**
     * Delegates the call to the wrapped component
     * Concrete decorators can override this to add behavior
     */
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    
    /**
     * Delegates the call to the wrapped component
     * Concrete decorators can override this to add behavior
     */
    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
