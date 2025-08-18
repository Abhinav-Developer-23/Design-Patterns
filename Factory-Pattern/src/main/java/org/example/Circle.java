package org.example;

/**
 * Circle class - Concrete Product in Factory Pattern
 * Implements the Shape interface
 */
public class Circle implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
        System.out.println("    ***    ");
        System.out.println("  *     *  ");
        System.out.println(" *       * ");
        System.out.println("*         *");
        System.out.println(" *       * ");
        System.out.println("  *     *  ");
        System.out.println("    ***    ");
        System.out.println();
    }
}
