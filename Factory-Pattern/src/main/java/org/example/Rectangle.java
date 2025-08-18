package org.example;

/**
 * Rectangle class - Concrete Product in Factory Pattern
 * Implements the Shape interface
 */
public class Rectangle implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
        System.out.println("*************");
        System.out.println("*           *");
        System.out.println("*           *");
        System.out.println("*           *");
        System.out.println("*************");
        System.out.println();
    }
}
